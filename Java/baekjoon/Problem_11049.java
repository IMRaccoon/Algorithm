import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            arr[i][0] = first;
            arr[i][1] = second;
        }
        for (int i = 0; i < N - 1; i++) dp[i][i + 1] = arr[i][0] * arr[i][1] * arr[i + 1][1];

        for (int d = 2; d < N; d++) {
            for (int i = 0; i < N - d; i++) {
                dp[i][i + d] = Integer.MAX_VALUE;
                for (int j = 0; j < d; j++) {
                    dp[i][i + d] = Math.min((arr[i][0] * arr[i + j][1] * arr[i + d][1]) + dp[i][i + j] + dp[i + j + 1][i + d], dp[i][i + d]);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}