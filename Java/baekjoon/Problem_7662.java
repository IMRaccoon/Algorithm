import java.io.*;
import java.util.*;

public class Problem_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        char cmd;

        int t = Integer.parseInt(br.readLine()), n, input;
        TreeMap<Integer, Integer> tre;

        for (int i = 0; i < t; i++) {
            tre = new TreeMap<>();
            n = Integer.parseInt(br.readLine());

            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                cmd = st.nextToken().charAt(0);
                input = Integer.parseInt(st.nextToken());

                if (cmd == 'I') {
                    tre.put(input, tre.getOrDefault(input, 0) + 1);
                } else {
                    if (tre.size() == 0) continue;

                    int tmp = input == -1 ? tre.firstKey() : tre.lastKey();
                    if (tre.put(tmp, tre.get(tmp) - 1) == 1) {
                        tre.remove(tmp);
                    }
                }
            }
            bw.write(tre.size() == 0 ? "EMPTY" : tre.lastKey() + " " + tre.firstKey());
            bw.newLine();
        }
        bw.flush();
    }
}
