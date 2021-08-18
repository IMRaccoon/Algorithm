import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_18809 {
    static int N, M, G, R;
    static Pos[] seeds;
    static int[] species;
    static int[][] map;
    static int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        ArrayList<Pos> available = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 0) map[i][j] = -1;
                if (input == 2) available.add(new Pos(i, j));
            }
        }
        seeds = available.toArray(Pos[]::new);
        species = new int[seeds.length];
        System.out.println(combination(0, 0, 0));
    }

    private static int combination(int start, int restR, int restG) {
        if (restR == R && restG == G) {
            return findFlowers();
        }

        int max = 0;
        for (int i = start; i < species.length; i++) {
            if (restR < R) {
                species[i] = 1;
                max = Math.max(max, combination(i + 1, restR + 1, restG));
                species[i] = 0;
            }
            if (restG < G) {
                species[i] = 2;
                max = Math.max(max, combination(i + 1, restR, restG + 1));
                species[i] = 0;
            }
        }
        return max;
    }

    private static int findFlowers() {
        Pair[][] clone = new Pair[N][M];

        ArrayDeque<Pos> q = new ArrayDeque<>();
        for (int i = 0; i < species.length; i++) {
            if(species[i] == 0) continue;
            clone[seeds[i].n][seeds[i].m] = new Pair(species[i], 0);
            q.offer(seeds[i]);
        }

        int flower = 0;
        while (!q.isEmpty()) {
            Pos cur = q.poll();
            if (clone[cur.n][cur.m].species == 3) continue;
            for (int[] dir : dirs) {
                int nextN = cur.n + dir[0], nextM = cur.m + dir[1];
                if (nextN == -1 || nextN == N || nextM == -1 || nextM == M) continue;
                if (map[nextN][nextM] == -1) continue;
                if (clone[nextN][nextM] == null) {
                    clone[nextN][nextM] = new Pair(clone[cur.n][cur.m].species, clone[cur.n][cur.m].curTime + 1);
                    q.offer(new Pos(nextN, nextM));
                    continue;
                }
                if (clone[nextN][nextM].species == clone[cur.n][cur.m].species) continue;
                if (clone[nextN][nextM].species == 2 && clone[cur.n][cur.m].species == 1) {
                    if (clone[nextN][nextM].curTime == clone[cur.n][cur.m].curTime + 1) {
                        clone[nextN][nextM].species = 3;
                        flower += 1;
                    }
                } else if (clone[nextN][nextM].species == 1 && clone[cur.n][cur.m].species == 2) {
                    if (clone[nextN][nextM].curTime == clone[cur.n][cur.m].curTime + 1) {
                        clone[nextN][nextM].species = 3;
                        flower += 1;
                    }
                }
            }
        }
        return flower;
    }

    private static class Pos {
        int n, m;

        Pos(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    private static class Pair {
        int curTime, species;

        Pair(int species, int curTime) {
            this.species = species;
            this.curTime = curTime;
        }
    }
}