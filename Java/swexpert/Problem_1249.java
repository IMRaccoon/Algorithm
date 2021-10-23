import java.io.*;
import java.util.PriorityQueue;

public class Problem_1249 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] map;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            char[] input;
            PriorityQueue<Pos> queue = new PriorityQueue<>();
            boolean [][] visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                input = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input[j] - '0';
                }
            }
            queue.offer(new Pos(0, 0, 0));
            visited[0][0] = true;

            while(!queue.isEmpty()) {
                Pos cur = queue.poll();
                if(cur.n == N - 1 && cur.m == N - 1) {
                    bw.write("#" + t + " " + cur.time);
                    bw.newLine();
                    break;
                }

                for (int[] dir : dirs) {
                    int nextN = dir[0] + cur.n, nextM = dir[1] + cur.m;
                    if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= N || visited[nextN][nextM]) continue;
                    visited[nextN][nextM] = true;
                    queue.offer(new Pos(nextN, nextM, cur.time + map[nextN][nextM]));
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Pos implements Comparable<Pos>{
        int n, m, time;

        Pos(int n, int m, int time) {
            this.n = n;
            this.m = m;
            this.time = time;
        }

        @Override
        public int compareTo(Pos pos) {
            return this.time - pos.time;
        }
    }
}
