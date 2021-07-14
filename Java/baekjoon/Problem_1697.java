import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1697 {
    static final int bound = 100001;
    static int[] arr = new int[bound];

    public static void main(String[] args) throws IOException {
        Arrays.fill(arr, Integer.MAX_VALUE);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        if (n == k) {
            System.out.println(0);
            return;
        }

        if (n > k) {
            System.out.println(n - k);
            return;
        }

        int count = 0, tmp;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        arr[n] = 0;
        q.add(n);

        while (!q.isEmpty()) {
            tmp = q.poll();
            count = arr[tmp] + 1;
            if (tmp + 1 < bound && arr[tmp + 1] > count) {
                arr[tmp + 1] = count;
                q.offer(tmp + 1);
                if (tmp + 1 == k) {
                    System.out.println(arr[tmp + 1]);
                    return;
                }
            }
            if (tmp - 1 >= 0 && arr[tmp - 1] > count) {
                arr[tmp - 1] = count;
                q.offer(tmp - 1);
                if (tmp - 1 == k) {
                    System.out.println(arr[tmp - 1]);
                    return;
                }
            }
            if (tmp * 2 < bound && arr[tmp * 2] > count) {
                arr[tmp * 2] = count;
                q.offer(tmp * 2);
                if (tmp * 2 == k) {
                    System.out.println(arr[tmp * 2]);
                    return;
                }
            }
        }
    }
}
