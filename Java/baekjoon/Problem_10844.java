import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] acc = new int[N][10];

        for (int i = 1; i <= 9; i++) acc[0][i] = 1;
        for (int i = 0; i < N - 1; i++) {
            acc[i + 1][0] = acc[i][1];
            for (int j = 1; j < 9; j++) {
                acc[i + 1][j] = (acc[i][j - 1] + acc[i][j + 1]) % 1_000_000_000;
            }
            acc[i + 1][9] = acc[i][8];
        }

        long sum = 0;
        for(int i = 0 ; i < 10; i++) sum += acc[N - 1][i];
        System.out.println(sum % 1_000_000_000);
    }
}