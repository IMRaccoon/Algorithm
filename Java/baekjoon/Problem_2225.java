import java.io.*;
import java.util.Arrays;

public class Problem_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);
        int [][] arr = new int[K][N + 1];
        Arrays.fill(arr[0], 1);
        for(int i = 1; i < K; i++) {
            arr[i][0] = arr[i - 1][0];
            for (int j = 1; j <= N; j++) {
                for (int k = 0; k <= j; k++) {
                    arr[i][j] = (arr[i][j] + arr[i - 1][k]) % 1_000_000_000;
                }
            }
        }
        System.out.println(arr[K - 1][N]);
    }
}