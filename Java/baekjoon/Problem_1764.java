import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        HashSet<String> set = new HashSet<>();
        ArrayList<String> arr = new ArrayList<>();
        String tmp;
        int answer = 0;

        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            tmp = br.readLine();
            if (set.contains(tmp)) {
                answer += 1;
                arr.add(tmp);
            }
        }
        bw.write(answer + "\n");
        arr.sort(String::compareTo);
        for (String s : arr) {
            bw.write(s + "\n");
        }

        bw.flush();
    }
}
