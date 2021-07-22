import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_7569 {
    final static int dir = 6;
    final static int [][] dirs = new int[][]{{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken()), N = Integer.parseInt(st.nextToken()), H = Integer.parseInt(st.nextToken());
        int[][][] map = new int[H][N][M];

        ArrayDeque<Pos> q = new ArrayDeque<>();
        int emptyCounter = 0;
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    map[h][n][m] = Integer.parseInt(st.nextToken());
                    if (map[h][n][m] == 1) q.offer(new Pos(h, n, m));
                    else if(map[h][n][m] == -1) emptyCounter += 1;
                }
            }
        }

        int answer = -1;
        int size = q.size();
        if(size == N * M * H) {
            System.out.println(0);
            return;
        }
        int counter = size;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            int n, m, h;

            for (int i = 0; i < dir; i++) {
                n = cur.n + dirs[i][0];
                m = cur.m + dirs[i][1];
                h = cur.h + dirs[i][2];

                if (n >= 0 && n < N && m >= 0 && m < M && h >= 0 && h < H) {
                    if (map[h][n][m] == 0) {
                        map[h][n][m] = 1;
                        q.offer(new Pos(h, n, m));
                        counter += 1;
                    }
                }
            }
            if (--size == 0) {
                answer += 1;
                size = q.size();
            }
        }
        if(counter + emptyCounter == N * M * H) {
            System.out.println(answer);
        } else {
            System.out.println(-1);
        }

    }

    private static class Pos {
        int n, m, h;

        Pos(int h, int n, int m) {
            this.h = h;
            this.n = n;
            this.m = m;
        }
    }
}
