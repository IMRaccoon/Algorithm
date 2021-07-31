import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem_13913 {
    static int[] arr;
    static int bound = 100_000;
    static int K;

    public static void main(String[] args) throws IOException {
        arr = new int[bound + 1];
        Arrays.fill(arr, Integer.MAX_VALUE);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        if (N >= K) {
            bw.write((N - K) + "\n");
            for (int i = N; i >= K; i--) {
                bw.write(i + " ");
            }
            bw.flush();
            return;
        }

        arr[N] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(N);

        while (!q.isEmpty() && q.peek() != K) {
            int cur = q.poll();
            int time = arr[cur] + 1;

            if (cur > 0 && cur * 2 <= bound && arr[cur * 2] > time) {
                arr[cur * 2] = time;
                q.offer(cur * 2);
            }
            if (cur + 1 <= K && arr[cur + 1] > time) {
                arr[cur + 1] = time;
                q.offer(cur + 1);
            }
            if (cur - 1 >= 0 && arr[cur - 1] > time) {
                arr[cur - 1] = time;
                q.offer(cur - 1);
            }
        }

        bw.write(arr[K] + "\n");
        bw.write(findRoute(N, 0));
        bw.flush();
    }

    private static String findRoute(int index, int count) {
        String tmp = "";
        if (count == arr[K]) {
            return index == K ? String.valueOf(index) : tmp;
        }
        if (index > 0 && index * 2 <= bound && arr[index * 2] == count + 1) {
            tmp = findRoute(index * 2, count + 1);
            if (!tmp.isEmpty()) return index + " " + tmp;
        }
        if (index + 1 <= K && arr[index + 1] == count + 1) {
            tmp = findRoute(index + 1, count + 1);
            if (!tmp.isEmpty()) return index + " " + tmp;
        }
        if (index - 1 >= 0 && arr[index - 1] == count + 1) {
            tmp = findRoute(index - 1, count + 1);
            if (!tmp.isEmpty()) return index + " " + tmp;
        }
        return tmp;
    }
}
