import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_14500 {
    static int[][][][] shapes = new int[][][][]{
            {{{1, 1, 1, 1}}, {{1}, {1}, {1}, {1}}},
            {{{1, 0}, {1, 0}, {1, 1}}, {{1, 1, 1}, {1, 0, 0}}, {{1, 1}, {0, 1}, {0, 1}}, {{0, 0, 1}, {1, 1, 1}}, {{0, 1}, {0, 1}, {1, 1}}, {{1, 0, 0}, {1, 1, 1}}, {{1, 1}, {1, 0}, {1, 0}}, {{1, 1, 1}, {0, 0, 1}}},
            {{{1, 0}, {1, 1}, {0, 1}}, {{0, 1, 1}, {1, 1, 0}}, {{0, 1}, {1, 1}, {1, 0}}, {{1, 1, 0}, {0, 1, 1}}},
            {{{1, 1}, {1, 1}}},
            {{{1, 1, 1}, {0, 1, 0}}, {{0, 1}, {1, 1}, {0, 1}}, {{0, 1, 0}, {1, 1, 1}}, {{1, 0}, {1, 1}, {1, 0}}}
    };
    static int[][] map;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer = Math.max(check(i, j), answer);
            }
        }
        System.out.println(answer);
    }

    private static int check(int n, int m) {
        int count = 0;
        for(int [][][] shape : shapes) {
            for (int[][] one : shape) {
                if (n + one.length > N || m + one[0].length > M) continue;
                int sum = 0;
                for (int i = 0; i < one.length; i++) {
                    for (int j = 0; j < one[i].length; j++) {
                        if (one[i][j] == 1) {
                            sum += map[n + i][m + j];
                        }
                    }
                }
                count = Math.max(sum, count);
            }
        }
        return count;
    }
}
