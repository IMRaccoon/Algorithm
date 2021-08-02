import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_2638 {
    static int [][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        boolean [][] cheese = new boolean[N][M];
        int count = 0;
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < M ;j++) {
                if(st.nextToken().equals("1")) {
                    cheese[i][j] = true;
                    count += 1;
                }
            }
        }
        int[][] air = new int[N][M];
        int days = 0;
        ArrayDeque<Pair> airs = new ArrayDeque<>();
        ArrayDeque<Pair> removable = new ArrayDeque<>();
        airs.offer(new Pair(0, 0));
        air[0][0] = 1;
        while(count != 0) {
            days += 1;

            while(!airs.isEmpty()) {
                Pair cur = airs.poll();
                for (int[] dir : dirs) {
                    int nextN = cur.n + dir[0], nextM = cur.m + dir[1];
                    if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= M) continue;
                    if (!cheese[nextN][nextM]) {
                        if (air[nextN][nextM] != 0) continue;
                        air[nextN][nextM] = 1;
                        airs.offer(new Pair(nextN, nextM));
                    } else {
                        air[nextN][nextM] -= 1;
                        if(air[nextN][nextM] == -2) {
                            removable.offer(new Pair(nextN, nextM));
                        }
                    }
                }
            }

            while(!removable.isEmpty()) {
                Pair cur = removable.poll();
                air[cur.n][cur.m] = 1;
                cheese[cur.n][cur.m] = false;
                count -= 1;
                airs.offer(cur);
            }
        }
        System.out.println(days);
    }
    private static class Pair {
        int n, m;
        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
