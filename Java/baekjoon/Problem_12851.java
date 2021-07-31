import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem_12851 {
    static int [] arr;
    public static void main(String[] args) throws IOException {
        int bound = 100_000;
        arr = new int[bound + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), K = Integer.parseInt(input[1]);
        if (N >= K) {
            System.out.println((N - K) + "\n" + "1");
            return;
        }

        arr[N] = 0;
        arr[K] = K - N;
        int count = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while (!q.isEmpty()) {
            int cur = q.poll();
            int time = arr[cur] + 1;
            if (time > arr[K]) break;

            if (cur * 2 <= bound && time <= arr[cur * 2]) {
                if (cur * 2 == K) {
                    count = check(time, cur * 2, count);
                } else {
                    arr[cur * 2] = time;
                    q.offer(cur * 2);
                }
            }
            if (cur + 1 <= K && time <= arr[cur + 1]) {
                if (cur + 1 == K) {
                    count = check(time, cur + 1, count);
                } else {
                    arr[cur + 1] = time;
                    q.offer(cur + 1);
                }
            }
            if (cur >= 1 && time <= arr[cur - 1]) {
                if (cur - 1 == K) {
                    count = check(time, cur - 1, count);
                } else {
                    arr[cur - 1] = time;
                    q.offer(cur - 1);
                }
            }
        }

        System.out.println(arr[K] + "\n" + count);
    }

    private static int check(int time, int index, int count) {
        if(time < arr[index]) {
            arr[index] = time;
            return 1;
        }
        return count + 1;
    }
}