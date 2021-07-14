import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int[] map = new int[n];
        int min = 0, max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, map[i]);
        }

        long sum;
        int mid;
        long answer = 0;

        while (min <= max) {
            sum = 0;
            mid = (min + max) / 2;
            for (int i = 0; i < n; i++) {
                if (mid < map[i]) {
                    sum += (map[i] - mid);
                }
            }
            if(sum >= m) {
                answer = Math.max(answer, mid);
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        System.out.println(answer);
    }
}