import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_16236 {
    static int[][] map;
    static int N;
    static int[][] dirs = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int sharkN = 0, sharkM = 0, size = 2, count = 0;
        int distance = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sharkN = i;
                    sharkM = j;
                    map[i][j] = 0;
                }
            }
        }

        int[] res;
        do {
            res = bfs(sharkN, sharkM, size);
            if (res == null) continue;
            sharkN = res[0];
            sharkM = res[1];
            distance += res[2];
            if (++count == size) {
                count = 0;
                size += 1;
            }
            map[sharkN][sharkM] = 0;
        } while (res != null);
        System.out.println(distance);
    }

    private static int[] bfs(int n, int m, int size) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        Pair fishes = null;
        q.offer(new Pair(n, m));
        boolean[][] visited = new boolean[N][N];
        int length = 1;
        int distance = 1;
        int deadLine = Integer.MAX_VALUE;
        visited[n][m] = true;
        while (!q.isEmpty()) {
            Pair cur = q.poll();

            for (int[] dir : dirs) {
                int nextN = cur.n + dir[0], nextM = cur.m + dir[1];
                if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= N) continue;
                if (visited[nextN][nextM]) continue;
                if (map[nextN][nextM] > size) continue;

                visited[nextN][nextM] = true;
                if (map[nextN][nextM] != 0 && map[nextN][nextM] < size) {
                    if(fishes == null) fishes = new Pair(nextN, nextM);
                    else if((fishes.n > nextN) || (fishes.n == nextN && fishes.m > nextM)) {
                        fishes.n = nextN;
                        fishes.m = nextM;
                    } else continue;
                    deadLine = distance;
                } else {
                    q.offer(new Pair(nextN, nextM));
                }
            }

            if(--length == 0) {
                length = q.size();
                if(distance == deadLine) break;
                distance += 1;
            }
        }

        return fishes == null ? null : new int[]{fishes.n, fishes.m, distance};
    }


    private static class Pair {
        int n, m;

        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
