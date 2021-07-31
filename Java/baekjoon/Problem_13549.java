import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem_13549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);
        if (N >= K) {
            System.out.println(N - K);
            return;
        }
        int[] arr = new int[400_000];
        Arrays.fill(arr, Integer.MAX_VALUE);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);
        arr[N] = 0;
        arr[K] = K - N;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur != 0) {
                for (int i = cur * 2; i - K <= arr[K]; i *= 2) {
                    if (arr[i] > i - K + arr[cur]) {
                        arr[i] = arr[cur];
                        q.offer(i);
                    }
                }
            }

            if (arr[cur] + 1 <= arr[K] && arr[cur + 1] > arr[cur] + 1) {
                arr[cur + 1] = arr[cur] + 1;
                q.offer(cur + 1);
            }
            if (cur >= 1 && arr[cur] + 1 <= arr[K] && arr[cur - 1] > arr[cur] + 1) {
                arr[cur - 1] = arr[cur] + 1;
                q.offer(cur - 1);
            }
        }
        System.out.println(arr[K]);
    }
}