import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Queue;
import java.util.LinkedList;

public class Problem_17836 {
    static int N;
    static int M;
    static int T;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        T = Integer.parseInt(str[2]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        bfs(new Pair(0, 0, 0, 0));
    }

    static void bfs(Pair start) {
        Queue<Pair> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[N][M][2];
        queue.add(start);

        while (!queue.isEmpty()) {
            Pair temp = queue.poll();
            int gram = temp.g;

            if (temp.t > T) continue;

            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];

                if (nx == N - 1 && ny == M - 1) {
                    System.out.println(temp.t + 1);
                    return;
                }

                if (nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny][gram]) continue;

                if (gram == 0) {
                    if (map[nx][ny] == 1) continue;
                    visited[nx][ny][gram] = true;

                    if (map[nx][ny] == 2)
                        queue.add(new Pair(nx, ny, 1, temp.t + 1));

                    else
                        queue.add(new Pair(nx, ny, 0, temp.t + 1));
                } else {
                    visited[nx][ny][gram] = true;
                    queue.add(new Pair(nx, ny, 1, temp.t + 1));
                }
            }
        }
        System.out.println("Fail");
    }

    static class Pair {
        int x;
        int y;
        int g;
        int t;

        public Pair(int x, int y, int g, int t) {
            this.x = x;
            this.y = y;
            this.g = g;
            this.t = t;
        }
    }
}