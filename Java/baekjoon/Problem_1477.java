import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        int[] gaps = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        arr[N] = L;
        Arrays.sort(arr);
        gaps[0] = arr[0];
        int end = gaps[0];
        for (int i = 0; i < N; i++) {
            gaps[i + 1] = arr[i + 1] - arr[i];
            end = Math.max(end, gaps[i + 1]);
        }

        int start = 1;
        int count;
        while (start < end) {
            int mid = (start + end) / 2;
            count = 0;
            for (int i = 0; i <= N; i++) {
                count += Math.ceil((gaps[i] - 1) / mid);
            }
            if (count > M) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        System.out.println(end);
    }
}
