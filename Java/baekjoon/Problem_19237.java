import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Problem_19237 {
    static int N, M, K;
    static HashMap<Integer, Pos> sharks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sharks = new HashMap<>();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Pair[][] map = new Pair[N][N];
        int[][][] sharkDirs = new int[M + 1][4][4];
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur == 0) continue;
                map[i][j] = new Pair(cur, K);
                sharks.put((i * N) + j, new Pos(cur, -1));
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            for (Map.Entry<Integer, Pos> entry : sharks.entrySet()) {
                if (entry.getValue().index == i) {
                    entry.getValue().dir = Integer.parseInt(st.nextToken()) - 1;
                    break;
                }
            }
        }

        for (int i = 1; i <= M; i++) {
            for (int dir = 0; dir < 4; dir++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 4; j++) {
                    sharkDirs[i][dir][j] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }


        for (int time = 1; time <= 1000; time++) {
            HashMap<Integer, Pos> nextSharks = new HashMap<>();

            for (Map.Entry<Integer, Pos> entry : sharks.entrySet()) {
                int pos = entry.getKey();
                Pos val = entry.getValue();
                int[] dir = sharkDirs[val.index][val.dir];
                boolean isFound = false;
                for (int d : dir) {
                    int nextN = (pos / N) + dirs[d][0], nextM = (pos % N) + dirs[d][1];
                    if (nextN == -1 || nextN == N || nextM == -1 || nextM == N) continue;
                    if (map[nextN][nextM] != null) continue;
                    isFound = true;
                    if ((nextSharks.get(nextN * N + nextM) == null) || (nextSharks.get(nextN * N + nextM).index > val.index)) {
                        nextSharks.put(nextN * N + nextM, new Pos(val.index, d));
                    }
                    break;
                }
                if (!isFound) {
                    for(int d : dir) {
                        int nextN = (pos / N) + dirs[d][0], nextM = (pos % N) + dirs[d][1];
                        if (nextN == -1 || nextN == N || nextM == -1 || nextM == N) continue;
                        if(map[nextN][nextM].visit == val.index) {
                            nextSharks.put(nextN * N + nextM, new Pos(val.index, d));
                            break;
                        }
                    }
                }
            }

            for(Map.Entry<Integer, Pos> entry : nextSharks.entrySet()) {
                int pos = entry.getKey();
                map[pos / N][pos % N] = new Pair(entry.getValue().index, K + 1);
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == null) continue;
                    if (map[i][j].time == 1) map[i][j] = null;
                    else map[i][j].time -= 1;
                }
            }

            sharks = nextSharks;
            if(sharks.size() == 1) {
                System.out.println(time);
                return;
            }
        }
        System.out.println(-1);
    }

    private static class Pair {
        int visit;
        int time;

        Pair(int visit, int time) {
            this.visit = visit;
            this.time = time;
        }

    }

    private static class Pos {
        int index, dir;

        Pos(int index, int dir) {
            this.index = index;
            this.dir = dir;
        }
    }
}
