import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_2933 {
    static boolean[][] map;
    static int[][] dirs = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
    static int R, C;
    static boolean [][] visited;
    static ArrayDeque<Pair> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j) == 'x';
            }
        }

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = R - Integer.parseInt(st.nextToken());
            boolean isBreak = false;
            int j;
            if (i % 2 == 0) {
                for (j = 0; j < C; j++) {
                    if (map[height][j]) {
                        isBreak = true;
                        break;
                    }
                }
            } else {
                for (j = C - 1; j >= 0; j--) {
                    if (map[height][j]) {
                        isBreak = true;
                        break;
                    }
                }
            }
            if(!isBreak) continue;
            map[height][j] = false;
            queue = new ArrayDeque<>();
            for (int[] dir : dirs) {
                int nextN = height + dir[0], nextM = j + dir[1];
                if (nextN < 0 || nextN >= R || nextM < 0 || nextM >= C) continue;
                if (map[nextN][nextM]) {
                    visited = new boolean[R][C];
                    if(!checkMap(nextN, nextM)) {
                        move();
                        break;
                    } else queue.clear();

                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                sb.append(map[r][c] ? "x" : ".");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    private static boolean checkMap(int n, int m) {
        ArrayDeque<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(n, m));
        visited[n][m] = true;
        queue.offer(new Pair(n, m));

        while (!q.isEmpty()) {
            Pair cur = q.poll();
            for (int[] dir : dirs) {
                int nextN = cur.n + dir[0], nextM = cur.m + dir[1];
                if (nextN < 0 || nextN > R || nextM < 0 || nextM >= C) continue;
                if (nextN == R) return true;
                if (!map[nextN][nextM]) continue;
                if (visited[nextN][nextM]) continue;
                visited[nextN][nextM] = true;
                q.offer(new Pair(nextN, nextM));
                queue.offer(new Pair(nextN, nextM));
            }
        }
        return false;
    }

    private static void move() {
        int movement = Integer.MAX_VALUE;
        for(Pair cur : queue) {
            map[cur.n][cur.m] = false;
        }
        int start, end;
        for(int c = 0; c < C; c++) {
            end = R;
            boolean canMove = false;
            for(start = R - 1; start >= 0; start --) {
                if(map[start][c]) end = start;
                else if(visited[start][c]) {
                    canMove = true;
                    break;
                }
            }
            if(canMove) {
                movement = Math.min(movement, end - start - 1);
            }
        }

        for(Pair cur : queue) {
            map[cur.n + movement][cur.m] = true;
        }
    }


    private static class Pair {
        int n, m;

        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}