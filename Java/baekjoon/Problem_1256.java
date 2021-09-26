import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1256 {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]), K = Integer.parseInt(input[2]);
        if (K == 1) {
            System.out.println("a".repeat(N) + "z".repeat(M));
            return;
        }

        arr = new int[N + 1][M + 1];
        Arrays.fill(arr[0], 1);
        for(int i = 0; i <= M; i++) {
            arr[1][i] = i + 1;
        }

        for (int n = 2; n <= N; n++) {
            arr[n][0] = 1;
            arr[n][1] = n + 1;
            for (int m = 2; m <= M; m++) {
                for (int j = 0; j <= m; j++) {
                    arr[n][m] = Math.min(arr[n][m] + arr[n - 1][j], 1_000_000_001);
                }
            }
        }
        if (arr[N][M] < K) {
            System.out.println(-1);
            return;
        }

        System.out.println(recursive(N - 1, M, K));
    }

    private static String recursive(int N, int M, int cur) {
        if(N == -1) return "z".repeat(M);
        if(M == -1) return "a".repeat(N);
        if (arr[N][M] >= cur) {
            return "a" + recursive(N - 1, M, cur);
        } else {
            return "z" + recursive(N, M - 1, cur - arr[N][M]);
        }
    }
}
