import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            long[] arr = new long[N + 1];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            arr[N] = 0;
            Stack<Integer> stack = new Stack<>();
            long max = 0;
            for (int i = 0; i <= N; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    long height = arr[stack.pop()];
                    max = Math.max(max, height * (stack.isEmpty() ? i : (i - stack.peek() - 1)));
                }
                stack.push(i);
            }
            bw.write(max + "\n");
        }
        bw.flush();
    }
}