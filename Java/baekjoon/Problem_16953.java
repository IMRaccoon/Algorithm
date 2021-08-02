import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem_16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int A = Integer.parseInt(input[0]), B = Integer.parseInt(input[1]);
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(B);
        int size = 1;
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            if(cur == A) {
                B = A;
                break;
            }

            if (cur % 10 == 1 && (cur / 10) >= A) {
                q.offer(cur / 10);
            } else if (cur % 2 == 0 && (cur / 2) >= A) {
                q.offer(cur / 2);
            }
            if(--size == 0) {
                size = q.size();
                count += 1;
            }
        }
        System.out.println(A == B ? count : -1);
    }
}
