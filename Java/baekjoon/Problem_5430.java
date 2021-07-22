import java.io.*;
import java.util.ArrayDeque;

public class Problem_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            StringBuilder ans = new StringBuilder();
            char[] cmd = br.readLine().toCharArray();
            int N = Integer.parseInt(br.readLine());
            boolean flag = true;

            boolean isReversed = false;
            ArrayDeque<Integer> q = new ArrayDeque<>();

            StringBuilder input = new StringBuilder(br.readLine());
            input.deleteCharAt(0).deleteCharAt(input.length() - 1);
            String[] inputs = input.toString().split(",");

            for (int i = 0; i < N; i++) {
                q.offer(Integer.parseInt(inputs[i]));
            }

            for (char c : cmd) {
                if (c == 'R') {
                    isReversed = !isReversed;
                } else if (c == 'D') {
                    if (q.isEmpty()) {
                        flag = false;
                        bw.write("error\n");
                        break;
                    }
                    if (isReversed) q.pollLast();
                    else q.pollFirst();
                }
            }
            if (!flag) continue;
            if (!q.isEmpty()) {
                while (!q.isEmpty()) {
                    ans.append(isReversed ? q.pollLast() : q.pollFirst()).append(",");
                }
                ans.deleteCharAt(ans.length() - 1);
            }
            bw.write("[" + ans.toString() + "]" + "\n");
        }
        bw.flush();
    }
}