import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_2206 {
    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                map[i][j] = input[j] == '0';
            }
        }

        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0, 0, 1, true));
        int[][][] distance = new int[N][M][2];
        distance[0][0][0] = 1;

        while (!q.isEmpty()) {
            Pos cur = q.poll();
            for (int[] dir : dirs) {
                int nextN = cur.n + dir[0], nextM = cur.m + dir[1];
                if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= M) continue;
                if (!map[nextN][nextM] && cur.canBreak) {
                    if (distance[nextN][nextM][1] == 0 || distance[nextN][nextM][1] > cur.distance + 1) {
                        distance[nextN][nextM][1] = cur.distance + 1;
                        q.offer(new Pos(nextN, nextM, cur.distance + 1, false));
                    }
                } else if (map[nextN][nextM]) {
                    if (distance[nextN][nextM][cur.canBreak ? 0 : 1] == 0 || distance[nextN][nextM][cur.canBreak ? 0 : 1] > cur.distance + 1) {
                        distance[nextN][nextM][cur.canBreak ? 0 : 1] = cur.distance + 1;
                        q.offer(new Pos(nextN, nextM, cur.distance + 1, cur.canBreak));
                    }
                }
            }
        }
        if (distance[N - 1][M - 1][0] == 0 && distance[N - 1][M - 1][1] == 0) {
            System.out.println(-1);
        } else if (distance[N - 1][M - 1][0] != 0 && distance[N - 1][M - 1][1] != 0) {
            System.out.println(Math.min(distance[N - 1][M - 1][0], distance[N - 1][M - 1][1]));
        } else {
            System.out.println(Math.max(distance[N - 1][M - 1][0], distance[N - 1][M - 1][1]));
        }
    }

    private static class Pos {
        int n, m;
        int distance;
        boolean canBreak;

        Pos(int n, int m, int distance, boolean canBreak) {
            this.n = n;
            this.m = m;
            this.distance = distance;
            this.canBreak = canBreak;
        }
    }
}