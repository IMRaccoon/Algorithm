import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_2931 {
    static int [][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Flow[][] map = new Flow[R][C];
        int startN = 0, startM = 0, endN = 0, endM = 0;

        for (int i = 0; i < R; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (input[j] == 'M') {
                    startN = i;
                    startM = j;
                } else if (input[j] == 'Z') {
                    endN = i;
                    endM = j;
                } else {
                    map[i][j] = blockToInt(input[j], i, j);
                }
            }
        }
        boolean [][] visited = new boolean[R][C];
        ArrayDeque<Flow> q = new ArrayDeque<>();
        for (int[] dir : dirs) {
            int nextN = startN + dir[0], nextM = startM + dir[1];
            if (nextN == -1 || nextN == R || nextM == -1 || nextM == C) continue;
            if (map[nextN][nextM] == null) continue;
            q.offer(map[nextN][nextM]);
            visited[nextN][nextM] = true;
        }
        visited[startN][startM] = true;
        visited[endN][endM] = true;

        int targetN = 0, targetM = 0;
        int firstDir = -1;
        while (!q.isEmpty()) {
            Flow cur = q.poll();
            for (int i = 0; i < 4; i++) {
                if (cur.canMove(i)) {
                    int nextN = cur.n + dirs[i][0], nextM = cur.m + dirs[i][1];
                    if (visited[nextN][nextM]) continue;
                    if (map[nextN][nextM] == null) {
                        targetN = nextN;
                        targetM = nextM;
                        firstDir = i % 2 == 0 ? i + 1 : i - 1;
                        break;
                    } else {
                        visited[nextN][nextM] = true;
                        q.offer(map[nextN][nextM]);
                    }
                }
            }
        }
        int secondDir = -1;
        int endDir = -1;
        int count = 0;
        for(int i = 0 ; i < 4; i++) {
            if (i == firstDir) continue;
            int nextN = targetN + dirs[i][0], nextM = targetM + dirs[i][1];
            if (nextN == -1 || nextN == R || nextM == -1 || nextM == C) continue;
            if (map[nextN][nextM] != null) {
                int tmp = i % 2 == 0 ? i + 1 : i - 1;
                if(map[nextN][nextM].canMove(tmp)) {
                    secondDir = i;
                    count += 1;
                }
            }
            if(nextN == endN && nextM == endM) {
                endDir = i;
            }
        }
        if(secondDir != -1) {
            System.out.println((targetN + 1) + " " + (targetM + 1) + " " + (count > 1 ? "+" : dirToChar(firstDir, secondDir)));
        } else {
            System.out.println((targetN + 1) + " " + (targetM + 1) + " " + dirToChar(firstDir, endDir));
        }
    }

    private static Flow blockToInt(char c, int n, int m) {
        switch (c) {
            case '1':
                return new Flow(false, true, false, true, n, m);
            case '2':
                return new Flow(true, false, false, true, n, m);
            case '3':
                return new Flow(true, false, true, false, n, m);
            case '4':
                return new Flow(false, true, true, false, n, m);
            case '|':
                return new Flow(true, true, false, false, n, m);
            case '-':
                return new Flow(false, false, true, true, n, m);
            case '+':
                return new Flow(true, true, true, true, n, m);
        }
        return null;
    }

    private static Character dirToChar(int first, int second) {
        if((first == 0 && second == 1) || (second == 0 && first == 1)) return '|';
        if((first == 2 && second == 3) || (second == 2 && first == 3)) return '-';
        if((first == 3 && second == 1) || (second == 3 && first == 1)) return '1';
        if((first == 0 && second == 3) || (second == 0 && first == 3)) return '2';
        if((first == 0 && second == 2) || (second == 0 && first == 2)) return '3';
        if((first == 2 && second == 1) || (second == 2 && first == 1)) return '4';
        return null;
    }

    private static class Flow {
        boolean top, bottom, left, right;
        int n, m;

        Flow(boolean top, boolean bottom, boolean left, boolean right, int n, int m) {
            this.top = top;
            this.bottom = bottom;
            this.left = left;
            this.right = right;
            this.n = n;
            this.m = m;
        }

        public boolean canMove(int dir) {
            if(dir == 0) return top;
            if(dir == 1) return bottom;
            if(dir == 2) return left;
            if(dir == 3) return right;
            return false;
        }
    }
}
