import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2228 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] sum = new int[n + 1];
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (i == 1) {
                sum[i] = arr[i];
            } else {
                sum[i] += sum[i - 1] + arr[i];
            }
        }

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }

        dp[1][1] = arr[0];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    dp[i][j] = sum[j];
                    for (int k = j; k > 0; k--) {
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k], sum[j] - sum[k - 1]));
                    }
                } else {
                    if (j < (i * 2) - 1) continue;
                    if (j == (i * 2) - 1) {
                        dp[i][j] = dp[i - 1][j - 2] + arr[j];
                        continue;
                    }
                    dp[i][j] = dp[i][j - 1];
                    for (int k = j - 1; k >= (i * 2) - 1; k--) {
                        dp[i][j] = Math.max(sum[j] - sum[k] + dp[i - 1][k - 1], dp[i][j]);
                    }
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}
