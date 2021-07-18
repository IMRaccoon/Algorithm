import java.io.*;
import java.util.*;

public class Problem_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        StringTokenizer st;
        String cmd;
        int num;

        int[] clear = new int[20];
        for (int i = 0; i < 20; i++) {
            clear[i] = i + 1;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            cmd = st.nextToken();
            if (cmd.equals("all")) {
                list.clear();
                for(int c : clear) {
                    list.add(c);
                }
            } else if (cmd.equals("empty")) {
                list.clear();
            } else {
                num = Integer.parseInt(st.nextToken());
                if (cmd.equals("add")) {
                    list.add(num);
                } else if (cmd.equals("remove")) {
                    list.remove((Integer) num);
                } else if (cmd.equals("check")) {
                    bw.write(list.indexOf(num) == -1 ? "0" : "1");
                    bw.newLine();
                } else if (cmd.equals("toggle")) {
                    if (!list.remove((Integer) num)) {
                        list.add(num);
                    }
                }
            }
        }
        bw.flush();
    }
}
