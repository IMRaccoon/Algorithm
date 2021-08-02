import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_14502 {
    static int[][] pos, map;
    static int [][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int N, M;
    static int answer;
    static ArrayList<Pos> virus;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        pos = new int[3][2];
        answer = 0;
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) virus.add(new Pos(i, j));
            }
        }

        makeCombination(0);
        System.out.println(answer);
    }


    private static void makeCombination(int count) {
        if (count == 3) {
            int[][] copy = new int[N][M];
            for (int i = 0; i < N; i++) copy[i] = Arrays.copyOf(map[i], M);
            for(int i = 0; i < count; i++) {
                copy[pos[i][0]][pos[i][1]] = 1;
            }
            int res = checkVirus(copy);
            answer = Math.max(res, answer);
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    boolean canAdd = true;
                    for(int k = 0 ; k < count; k++) {
                        if(pos[k][0] == i && pos[k][1] == j) {
                            canAdd =false;
                            break;
                        }
                    }
                    if(canAdd) {
                        pos[count][0] = i;
                        pos[count][1] = j;
                        makeCombination(count + 1);
                    }
                }
            }
        }
    }

    private static int checkVirus(int [][] arr) {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        for(Pos v : virus) q.offer(new Pos(v.n, v.m));
        while(!q.isEmpty()) {
            Pos cur = q.poll();
            for(int [] dir : dirs) {
                int nextN = cur.n + dir[0], nextM = cur.m + dir[1];
                if(nextN < 0 || nextN >= N || nextM < 0 || nextM >= M) continue;
                if(arr[nextN][nextM] == 0) {
                    q.offer(new Pos(nextN, nextM));
                    arr[nextN][nextM] = 2;
                }
            }
        }

        int count = 0;
        for(int i = 0 ; i < N ; i++) {
            for(int j = 0 ; j < M; j++) {
                if(arr[i][j] == 0) count += 1;
            }
        }
        return count;
    }

    private static class Pos {
        int n, m;

        Pos(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
