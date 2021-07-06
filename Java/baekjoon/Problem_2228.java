import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2228 {
    static int[] arr;
    static int[][] dp;
    static int[] sum;
    static final int MIN = -3276801;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        dp = new int[n + 1][m + 1];
        sum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i - 1] + arr[i];
            Arrays.fill(dp[i], MIN);
        }
        Arrays.fill(dp[0], MIN);
        dp[1][1] = arr[1];

        for(int i = 2; i <= n; i++) {
            dp[i][1] = dp[i - 1][1];
            for (int k = i - 1; k >= 0; k--) {
                dp[i][1] = Math.max(dp[i][1], sum[i] - sum[k]);
            }

            for (int j = 2; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];

                for (int k = i - 2; k > 0; k--) {
                    dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + sum[i] - sum[k + 1]);
                }
            }
        }

        System.out.println(dp[n][m]);
    }
}

