import java.io.*;
import java.util.ArrayList;

public class Problem_20437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            ArrayList<Integer>[] alpha = new ArrayList[26];
            char[] S = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());
            for (int i = 0; i < 26; i++) alpha[i] = new ArrayList<>();
            int min = Integer.MAX_VALUE, max = 0;
            for (int i = 0; i < S.length; i++) {
                int cur = S[i] - 'a';
                alpha[cur].add(i);
                int size = alpha[cur].size();
                if (size >= K) {
                    int range = i - alpha[cur].get(size - K) + 1;
                    min = Math.min(range, min);
                    max = Math.max(range, max);
                }
            }
            if (max == 0) bw.write(-1 + "\n");
            else bw.write(min + " " + max + "\n");

        }
        bw.flush();
    }
}