import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_2178 {
    static int[][] map;
    final static int dir = 4;
    final static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j] - '0';
            }
        }
        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0, 0));

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if(cur.m == M - 1 && cur.n == N - 1) break;

            for (int i = 0; i < dir; i++) {
                int m = cur.m + dirs[i][0];
                int n = cur.n + dirs[i][1];
                if (m >= 0 && m < M && n >= 0 && n < N && map[n][m] == 1) {
                    map[n][m] = map[cur.n][cur.m] + 1;
                    q.offer(new Pos(n, m));
                }
            }
        }
        System.out.println(map[N - 1][M - 1]);
    }

    private static class Pos {
        int n, m;

        Pos(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
