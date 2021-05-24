import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int [][] map = new int[n+1][n+1];

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                map[i][j] = Integer.MAX_VALUE;
            }
            map[i][i] = 0;
        }

        int first, second;
        for(int i = 0 ; i < m; i ++) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            map[first][second] = 1;
            map[second][first] = 1;
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j) continue;
                if(map[j][i] == Integer.MAX_VALUE) continue;
                for(int k = 1; k <= n; k++) {
                    if(map[i][k] == Integer.MAX_VALUE) continue;
                    map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                }
            }
        }

        int minIndex = 0;
        int minSum = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            int sum = 0;
            for(int j = 1; j <= n; j++) {
                sum += map[i][j];
            }
            if(sum < minSum) {
                minIndex = i;
                minSum = sum;

            }
        }
        System.out.println(minIndex);
    }
}
