import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);

        int[][] acc = new int[K + 1][N + 1];

        for (int i = 1; i <= K; i++) {
            input = br.readLine().split(" ");
            int P = Integer.parseInt(input[0]), T = Integer.parseInt(input[1]);

            for (int j = 1; j <= N; j++) {
                if (j < T) acc[i][j] = acc[i - 1][j];
                else acc[i][j] = Math.max(acc[i - 1][j], acc[i - 1][j - T] + P);
            }
        }
        System.out.println(acc[K][N]);
    }
}
