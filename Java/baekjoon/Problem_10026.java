import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10026 {
    final static int[] dirN = new int[]{1, -1, 0, 0};
    final static int[] dirM = new int[]{0, 0, 1, -1};
    static int N;
    static int[][] map;
    static boolean[][] originVisit;
    static boolean[][] blueVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        originVisit = new boolean[N][N];
        blueVisit = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            char[] cur = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                if (cur[j] == 'R') map[i][j] = -1;
                else if (cur[j] == 'G') map[i][j] = 0;
                else map[i][j] = 1;
            }
        }

        int origin = 0;
        int blue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!originVisit[i][j]) {
                    origin += 1;
                    dfs(i, j, map[i][j]);
                }
                if(!blueVisit[i][j]) {
                    blue += 1;
                    dfs_2(i, j, map[i][j] > 0);
                }
            }
        }
        System.out.println(origin + " " + blue);
    }

    private static void dfs(int n, int m, int visited) {
        originVisit[n][m] = true;
        for (int i = 0; i < 4; i++) {
            if(n + dirN[i] < 0 || n + dirN[i] >= N) continue;
            if(m + dirM[i] < 0 || m + dirM[i] >= N) continue;
            if(originVisit[n + dirN[i]][m + dirM[i]]) continue;
            if(map[n + dirN[i]][m + dirM[i]] != visited) continue;
            dfs(n + dirN[i], m + dirM[i], visited);
        }
    }
    private static void dfs_2(int n, int m, boolean isBlue) {
        blueVisit[n][m] = true;
        for (int i = 0; i < 4; i++) {
            if(n + dirN[i] < 0 || n + dirN[i] >= N) continue;
            if(m + dirM[i] < 0 || m + dirM[i] >= N) continue;
            if(blueVisit[n + dirN[i]][m + dirM[i]]) continue;
            if(isBlue && map[n + dirN[i]][m + dirM[i]] <= 0) continue;
            if(!isBlue && map[n + dirN[i]][m + dirM[i]] > 0) continue;
            dfs_2(n + dirN[i], m + dirM[i], isBlue);
        }
    }
}
