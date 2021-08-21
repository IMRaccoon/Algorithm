import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_19236 {
    static int[][] dirs = new int[][]{{-1, 0}, {-1, -1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}, {0, 1}, {-1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Pair[][] map = new Pair[4][4];
        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                int num = Integer.parseInt(st.nextToken()), dir = Integer.parseInt(st.nextToken());
                map[i][j] = new Pair(num, dir - 1);
            }
        }
        System.out.println(moveAndEat(0, 0, map));
    }

    private static int moveAndEat(int n, int m, Pair[][] map) {
        int sharkDir = map[n][m].dir;
        int res = map[n][m].index;
        map[n][m] = null;

        Pair cur, tmp;
        for(int t = 1; t <= 16; t++) {
            boolean found = false;
            for (int i = 0; i < 4 && !found; i++) {
                for (int j = 0; j < 4 && !found; j++) {
                    if (map[i][j] == null) continue;
                    if (map[i][j].index == t) {
                        found = true;
                        cur = map[i][j];
                        for (int d = 0; d < 8; d++) {
                            int[] dir = dirs[(d + cur.dir) % 8];
                            int nextN = i + dir[0], nextM = j + dir[1];
                            if (nextN == -1 || nextN == 4 || nextM == -1 || nextM == 4) continue;
                            if (map[nextN][nextM] == null && !(nextN == n && nextM == m)) {
                                map[nextN][nextM] = new Pair(cur.index, (d + cur.dir) % 8);
                                map[i][j] = null;
                                break;
                            } else if(map[nextN][nextM] != null){
                                tmp = new Pair(map[nextN][nextM].index, map[nextN][nextM].dir);
                                map[nextN][nextM] = new Pair(cur.index, (d + cur.dir) % 8);
                                map[i][j] = tmp;
                                break;
                            }
                        }
                    }
                }
            }
        }
        int max = 0;
        for(int i = 1; i < 4; i++) {
            int nextN = n + (dirs[sharkDir][0] * i), nextM = m + (dirs[sharkDir][1] * i);
            if (nextN == -1 || nextN == 4 || nextM == -1 || nextM == 4) break;
            if(map[nextN][nextM] == null) continue;
            max = Math.max(max, moveAndEat(nextN, nextM, copyAll(map)));
        }
        return max + res;
    }

    private static Pair[][] copyAll(Pair[][] map) {
        Pair[][] newMap = new Pair[4][4];
        for(int i = 0 ; i < 4; i++) {
            for(int j = 0 ; j < 4; j++){
                if(map[i][j] == null) continue;
                newMap[i][j] = new Pair(map[i][j].index, map[i][j].dir);
            }
        }
        return newMap;
    }

    private static class Pair {
        int index;
        int dir;

        Pair(int index, int dir) {
            this.index = index;
            this.dir = dir;
        }
    }
}