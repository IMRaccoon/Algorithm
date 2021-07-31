import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];
        int[][] items = new int[N + 1][2];


        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken());
            items[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= N; i++) {
            for (int j = 0; j <= K; j++) {
                if(j < items[i][0]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = Math.max(dp[i - 1][j - items[i][0]] + items[i][1], dp[i - 1][j]);
            }
        }
        System.out.println(dp[N][K]);
    }
}
