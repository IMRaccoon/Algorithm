import java.io.*;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Set;

public class Problem_2819 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int [][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        for(int t = 1; t <= T; t++) {
            int [][] map = new int[4][4];
            ArrayDeque<Pos> queue = new ArrayDeque<>();

            for(int i = 0 ; i < 4; i++) {
                String[] input = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    queue.offer(new Pos(i, j, map[i][j]));
                }
            }

            int nextN, nextM;
            for(int i = 0 ; i < 6; i++) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    Pos cur = queue.poll();
                    for (int[] dir : dirs) {
                        nextN = dir[0] + cur.n;
                        nextM = dir[1] + cur.m;

                        if (nextN == -1 || nextN == 4 || nextM == -1 || nextM == 4) continue;
                        queue.offer(new Pos(nextN, nextM, cur.val * 10 + map[nextN][nextM]));
                    }
                }
            }

            HashSet<Integer> set = new HashSet<>();
            while(!queue.isEmpty()) {
                set.add(queue.poll().val);
            }
            bw.write("#" + t + " " + set.size());
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static class Pos {
        int n, m, val;

        Pos(int n, int m, int val) {
            this.n = n;
            this.m = m;
            this.val = val;
        }
    }
}
