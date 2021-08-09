import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_5463 {
    static int[][] grape;
    static int[][] sum;
    static int[][][][] acc;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        grape = new int[N][M];
        sum = new int[N + 1][M + 1];
        acc = new int[N][N][M][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grape[i][j] = Integer.parseInt(st.nextToken());
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + grape[i][j];
            }
        }
        System.out.println(recursive(0, N - 1, 0, M - 1));
    }

    private static int recursive(int startN, int endN, int startM, int endM) {
        if (startN == endN && startM == endM) return 0;
        if (acc[startN][endN][startM][endM] != 0) return acc[startN][endN][startM][endM];

        int column = Integer.MAX_VALUE, row = Integer.MAX_VALUE, sum = getSum(startN, endN, startM, endM);
        for (int i = startN; i < endN; i++) {
            column = Math.min(column, recursive(startN, i, startM, endM) + recursive(i + 1, endN, startM, endM));
        }
        for (int i = startM; i < endM; i++) {
            row = Math.min(row, recursive(startN, endN, startM, i) + recursive(startN, endN, i + 1, endM));
        }
        acc[startN][endN][startM][endM] = Math.min(column, row) + sum;
        return acc[startN][endN][startM][endM];
    }

    private static int getSum(int startN, int endN, int startM, int endM) {
        return sum[endN + 1][endM + 1] - sum[startN][endM + 1] - sum[endN + 1][startM] + sum[startN][startM];
    }
}