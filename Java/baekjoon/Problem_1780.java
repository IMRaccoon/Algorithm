import java.io.*;
import java.util.StringTokenizer;

public class Problem_1780 {
    static int[][] map;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        answer = new int[3];
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        checkSquare(0, 0, N, N);
        System.out.println(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
    }

    private static void checkSquare(int startI, int startJ, int endI, int endJ) {
        int init = map[startI][startJ];
        if(endI - startI == 1) {
            answer[init + 1] += 1;
            return;
        }
        for (int i = startI; i < endI; i++) {
            for (int j = startJ; j < endJ; j++) {
                if (init != map[i][j]) {
                    int dif = (endI - startI) / 3;
                    for (int a = startI; a < endI; a += dif) {
                        for (int b = startJ; b < endJ; b += dif) {
                            checkSquare(a, b, a + dif, b + dif);
                        }
                    }
                    return;
                }
            }
        }
        answer[init + 1] += 1;
    }
}