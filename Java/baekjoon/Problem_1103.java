import java.io.*;
import java.util.StringTokenizer;

public class Problem_1103 {
    final static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static int[][] dp;
    static boolean[][] visited;
    static int N, M;
    static boolean isLoop = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) map[i][j] = input[j] == 'H' ? 0 : input[j] - '0';
        }
        dfs(0, 0);
        System.out.println(isLoop ? -1 : dp[0][0] + 1);
    }

    private static int dfs(int n, int m) {
        if (visited[n][m]) isLoop = true;
        if (isLoop) return -1;
        if (dp[n][m] != 0) return dp[n][m];
        visited[n][m] = true;
        dp[n][m] = 0;
        for (int i = 0; i < 4; i++) {
            int nextN = n + (dirs[i][0] * map[n][m]), nextM = m + (dirs[i][1] * map[n][m]);
            if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= M || map[nextN][nextM] == 0) continue;
            if (map[n][m] == map[nextN][nextM]) isLoop = true;
            else dp[n][m] = Math.max(dp[n][m], dfs(nextN, nextM) + 1);
        }
        visited[n][m] = false;
        return dp[n][m];
    }
}
