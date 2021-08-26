import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_20057 {
    static int N;
    static int[][][] dirs = new int[][][]{
            {{0, -2}, {1, -1}, {-1, -1}, {1, 0}, {-1, 0}, {2, 0}, {-2, 0}, {-1, 1}, {1, 1}}, // 윈쪽
            {{0, 2}, {1, 1}, {-1, 1}, {1, 0}, {-1, 0}, {2, 0}, {-2, 0}, {1, -1}, {-1, -1}}, // 오른쪽
            {{-2, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {0, 2}, {0, -2}, {1, 1}, {1, -1}}, // 위
            {{2, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {0, 2}, {0, -2}, {-1, 1}, {-1, -1}}, // 아래
    };
    static double[] percentage = new double[]{0.05, 0.1, 0.1, 0.07, 0.07, 0.02, 0.02, 0.01, 0.01};
    static final int AREA = 9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int answer = 0;

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        int[] prev = new int[]{N / 2, N / 2};
        int nextN, nextM, blowUp;
        for (int move = 1; move < N * N; move++) {
            int[] cur = getPos(move);
            if (map[cur[0]][cur[1]] == 0) {
                prev = cur;
                continue;
            }

            int curSand = map[cur[0]][cur[1]];
            int originSand = curSand;
            map[cur[0]][cur[1]] = 0;
            int dirN = cur[0] - prev[0];
            int dirM = cur[1] - prev[1];
            int d = dirN == 0 ? (dirM == -1 ? 0 : 1) : dirN == -1 ? 2 : 3;

            if (originSand / 10 != 0) {
                for (int i = 0; i < AREA; i++) {
                    int[] dir = dirs[d][i];
                    nextN = cur[0] + dir[0];
                    nextM = cur[1] + dir[1];
                    blowUp = (int) Math.floor(originSand * percentage[i]);
                    if (blowUp == 0) continue;
                    if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= N) answer += blowUp;
                    else map[nextN][nextM] += blowUp;
                    curSand -= blowUp;
                }
            }
            nextN = cur[0] + dirN;
            nextM = cur[1] + dirM;
            if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= N) answer += curSand;
            else map[nextN][nextM] += curSand;
            prev = cur;
        }
        System.out.println(answer);
    }


    private static int[] getPos(int move) {
        int distance = 1;
        for (; distance < ((N - 1) / 2); distance++) {
            if (move < Math.pow(distance * 2 + 1, 2)) break;
        }
        move -= Math.pow(distance * 2 - 1, 2);
        int div = move / (distance * 2);
        int mod = move % (distance * 2);
        int n, m;
        if (div == 0) {
            n = (N / 2) - distance + 1 + mod;
            m = (N / 2) - distance;
        } else if (div == 1) {
            n = (N / 2) + distance;
            m = (N / 2) - distance + 1 + mod;
        } else if (div == 2) {
            n = (N / 2) + distance - 1 - mod;
            m = (N / 2) + distance;
        } else {
            n = (N / 2) - distance;
            m = (N / 2) + distance - 1 - mod;
        }
        return new int[]{n, m};
    }
}