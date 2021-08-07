import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2616 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] sum = new int[N + 1];
        for (int i = 0; i < N; i++) {
            sum[i + 1] = sum[i] + Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][3];

        for (int i = M; i <= N; i++) {
            int cur = sum[i] - sum[i - M];
            dp[i][0] = Math.max(dp[i - 1][0], cur);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - M][0] + cur);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - M][1] + cur);
        }
        System.out.println(dp[N][2]);
    }
}
