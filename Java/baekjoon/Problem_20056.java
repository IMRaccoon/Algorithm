import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_20056 {
    static int[][] dirs = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());

        ArrayDeque<Fire> moveFire = new ArrayDeque<>();
        ArrayDeque<Pos> combinedFire = new ArrayDeque<>();

        Fire[][] map = new Fire[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()) - 1, m = Integer.parseInt(st.nextToken()) - 1;
            moveFire.offer(new Fire(n, m, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Fire cur, other;
        int nextN, nextM;
        for (int k = 0; k < K; k++) {
            while (!moveFire.isEmpty()) {
                cur = moveFire.poll();
                nextN = (dirs[cur.dir][0] * (cur.speed % N)) + cur.n;
                nextM = (dirs[cur.dir][1] * (cur.speed % N)) + cur.m;
                if(nextN < 0) nextN += N;
                if(nextM < 0) nextM += N;
                if(nextN >= N) nextN -= N;
                if(nextM >= N) nextM -= N;
                if (map[nextN][nextM] == null) {
                    map[nextN][nextM] = new Fire(nextN, nextM, cur.weight, cur.speed, cur.dir);
                } else {
                    other = map[nextN][nextM];
                    if (other.duplicate == 1) combinedFire.offer(new Pos(nextN, nextM));
                    other.duplicate += 1;
                    other.speed += cur.speed;
                    other.weight += cur.weight;
                    if (other.dir != -1) other.dir = (other.dir + cur.dir) % 2 == 0 ? other.dir % 2 : -1;
                }
            }

            while (!combinedFire.isEmpty()) {
                Pos p = combinedFire.poll();
                cur = map[p.n][p.m];
                if (cur.weight / 5 != 0) {
                    for (int i = cur.dir < 0 ? 1 : 0; i < 8; i += 2) {
                        moveFire.offer(new Fire(cur.n, cur.m, cur.weight / 5, cur.speed / cur.duplicate, i));
                    }
                }
                map[p.n][p.m] = null;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == null) continue;
                    moveFire.offer(new Fire(i, j, map[i][j].weight, map[i][j].speed, map[i][j].dir));
                }
            }

            map = new Fire[N][N];
        }
        int ans = 0;

        while(!moveFire.isEmpty()) {
            cur = moveFire.poll();
            ans += cur.weight;
        }

        System.out.println(ans);
    }

    private static class Pos {
        int n, m;

        Pos(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    private static class Fire extends Pos {
        int weight, dir, speed;
        int duplicate;

        Fire(int n, int m, int weight, int speed, int dir) {
            super(n, m);
            this.weight = weight;
            this.speed = speed;
            this.dir = dir;
            this.duplicate = 1;
        }
    }
}

// 7 0 1
// 6   2
// 5 4 3

// 1 3 12 3 1
// X 0 0 X
// 0 0 0 0
// 0 0 0 0
// 0 0 0 0