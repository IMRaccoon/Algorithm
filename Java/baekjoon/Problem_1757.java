import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int [] distances = new int[n];
        for(int i = 0 ; i < n; i++) {
            distances[i] = Integer.parseInt(br.readLine());
        }

        // 0 은 쉴때, 1 은 달릴때
        int [][][] map = new int[n][m + 1][2];
        map[0][1][1] = distances[0];

        for(int i = 1; i < n; i ++) {
            map[i][0][0] = Math.max(map[i-1][1][0], map[i-1][0][0]);
            map[i][0][1] = map[i][0][0];
            for(int j = 1; j < m; j++) {
                map[i][j][0] = map[i - 1][j + 1][0];
                map[i][j][1] = map[i - 1][j - 1][1] + distances[i];
            }
            map[i][m][1] = map[i-1][m-1][1] + distances[i];
            map[i][m][0] = map[i][m][1];
        }
        System.out.println(map[n - 1][0][0]);
    }
}