import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11567 {
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, M, startN, startM, endN, endM;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j] == '.';
            }
        }
        st = new StringTokenizer(br.readLine());
        startN = Integer.parseInt(st.nextToken()) - 1;
        startM = Integer.parseInt(st.nextToken()) - 1;
        st = new StringTokenizer(br.readLine());
        endN = Integer.parseInt(st.nextToken()) - 1;
        endM = Integer.parseInt(st.nextToken()) - 1;

        int count = 0;
        map[startN][startM] = true;
        for (int[] dir : dirs) {
            int nextN = endN + dir[0], nextM = endM + dir[1];
            if (nextN == -1 || nextN == N || nextM == -1 || nextM == M) continue;
            if (map[nextN][nextM]) count += 1;
        }
        if (startN == endN && startM == endM) {
            System.out.println(count >= 1 ? "YES" : "NO");
            return;
        }
        if ((map[endN][endM] && count < 2) || (!map[endN][endM] && count < 1)) {
            System.out.println("NO");
            return;
        }
        map[startN][startM] = false;

        System.out.println(dfs(startN, startM) ? "YES" : "NO");

    }

    private static boolean dfs(int curN, int curM) {
        for (int[] dir : dirs) {
            int nextN = dir[0] + curN, nextM = dir[1] + curM;
            if (nextN == -1 || nextN == N || nextM == -1 || nextM == M) continue;
            if (nextN == endN && nextM == endM) return true;
            if (!map[nextN][nextM]) continue;

            map[nextN][nextM] = false;
            if (dfs(nextN, nextM)) return true;
        }
        return false;
    }
}
