import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        int[] dp = new int[N];

        int max = 1;
        for (int i = 0; i < N; i++) {
            dp[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        LinkedList<Integer> answer = new LinkedList<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == max) {
                max -= 1;
                answer.addFirst(arr[i]);
            }
        }

        bw.write(answer.size() + "\n");
        for (int ans : answer) {
            bw.write(ans + " ");
        }
        bw.flush();
    }
}