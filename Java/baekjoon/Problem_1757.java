import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int[] distances = new int[n];
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.parseInt(br.readLine());
        }

        int[][][] map = new int[n + 1][m + 1][2];
        for (int i = 1; i <= n; i++) {
            map[i][0][1] = Math.max(map[i - 1][0][1], map[i - 1][1][0]);
            for (int j = 1; j < m; j++) {
                map[i][j][1] = map[i - 1][j - 1][1] + distances[i - 1];
                map[i][j][0] = Math.max(map[i - 1][j + 1][0], map[i][j][1]);
            }
            map[i][m][0] = map[i - 1][m - 1][1] + distances[i - 1];
        }

        System.out.println(map[n][0][1]);
    }
}