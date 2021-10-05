import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);

        int[] length = new int[N];
        for (int i = 0; i < N; i++) {
            length[i] = br.readLine().length();
        }

        int[] count = new int[21];
        for (int i = 0; i < K; i++) {
            count[length[i]] += 1;
        }
        long answer = 0;
        for (int i = 0; i < N; i++) {
            if (i + K < N) count[length[i + K]] += 1;
            answer += (--count[length[i]]);
        }
        System.out.println(answer);
    }
}
