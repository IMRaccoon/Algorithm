import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    if (j == 0) dp[i][j] = map[i][j] == 0 ? 1 : 0;
                    else dp[i][j] = dp[i][j - 1] % 3 == map[i][j] ? dp[i][j - 1] + 1 : dp[i][j - 1];
                } else {
                    if (j == 0) dp[i][j] = dp[i - 1][j] % 3 == map[i][j] ? dp[i - 1][j] + 1 : dp[i - 1][j];
                    else {
                        dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] % 3 == map[i][j] ? dp[i][j - 1] + 1 : dp[i][j - 1]);
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j] % 3 == map[i][j] ? dp[i - 1][j] + 1 : dp[i - 1][j]);
                    }
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }
}
