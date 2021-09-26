import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Problem_6068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] works = new int[N][2];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            works[i][0] = Integer.parseInt(input[0]);
            works[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(works, Comparator.comparingInt(w -> w[1]));

        int start = 0;
        int diff = Integer.MAX_VALUE;
        for(int [] work: works) {
            start += work[0];
            if (start > work[1]) {
                System.out.println(-1);
                return;
            } else {
                diff = Math.min(diff, work[1] - start);
            }
        }
        System.out.println(diff);
    }
}
