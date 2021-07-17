import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        int k = Integer.parseInt(br.readLine());

        long left = 1, right = n * n, mid, count, answer = 1;
        while (left <= right) {
            mid = (left + right) / 2;
            count = 0;
            for (int i = 1; i <= n; i++) {
                count += Math.min(n, mid / i);
            }

            if (k > count) {
                left = mid + 1;
            } else {
                answer = mid;
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
