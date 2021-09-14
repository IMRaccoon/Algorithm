import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2229 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);

        int[][] dp = new int[N + 1][N + 1];
        for (int i = 2; i <= N; i++) {
            for (int group = 1; group < i; group++) {
                dp[i][group] = dp[i - 1][group];
                for (int k = i - 2; k >= group - 1; k--) {
                    dp[i][group] = Math.max(dp[i][group], dp[k][group - 1] + (Math.abs(arr[i - 1] - arr[k])));
                }
            }
        }
        int answer = 0;
        for(int i = 0 ; i <= N; i++) {
            answer = Math.max(answer, dp[N][i]);
        }
        System.out.println(answer);
    }
}
