import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            dp[i] = arr[i];
            int max = 0;
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j] && max < dp[j]) {
                    max = dp[j];
                }
            }
            dp[i] += max;
        }

        int answer = 0;
        for (int sum : dp) {
            answer = Math.max(sum, answer);
        }
        System.out.println(answer);
    }
}
