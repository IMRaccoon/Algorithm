import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int [][] maxDP = new int[N][3];
        int [][] minDP = new int[N][3];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                maxDP[i][j] = minDP[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 1 ; i < N; i++) {
            // 0
            maxDP[i][0] += Math.max(maxDP[i - 1][0], maxDP[i - 1][1]);
            minDP[i][0] += Math.min(minDP[i - 1][0], minDP[i - 1][1]);
            // 1
            maxDP[i][1] += Math.max(Math.max(maxDP[i - 1][0], maxDP[i - 1][1]), maxDP[i - 1][2]);
            minDP[i][1] += Math.min(Math.min(minDP[i - 1][0], minDP[i - 1][1]), minDP[i - 1][2]);
            // 2
            maxDP[i][2] += Math.max(maxDP[i - 1][1], maxDP[i - 1][2]);
            minDP[i][2] += Math.min(minDP[i - 1][1], minDP[i - 1][2]);
        }

        System.out.println(
                Math.max(maxDP[N - 1][0], Math.max(maxDP[N - 1][1], maxDP[N - 1][2])) + " " + Math.min(minDP[N-1][0], Math.min(minDP[N-1][1], minDP[N-1][2])));
    }
}
