import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int[][] counts = new int[N + 1][2];

        for (int i = 0; i < N; i++) {
            if (arr[i] == 'A') {
                counts[i + 1][0] = counts[i][0];
                counts[i + 1][1] = Math.min(counts[i][1] + 1, counts[i][0] + 1);
            } else {
                counts[i + 1][0] = Math.min(counts[i][0] + 1, counts[i][1] + 1);
                counts[i + 1][1] = counts[i][1];
            }
        }
        System.out.println(Math.min(counts[N][0], counts[N][1] + 1));
    }
}
