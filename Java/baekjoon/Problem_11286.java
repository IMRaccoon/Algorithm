import java.io.*;
import java.util.PriorityQueue;

public class Problem_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((t1, t2) -> Math.abs(t1) == Math.abs(t2) ? t1 - t2 : Math.abs(t1) - Math.abs(t2));
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                bw.write(q.isEmpty() ? "0\n" : (q.poll() + "\n"));
            } else {
                q.offer(input);
            }
        }
        bw.flush();
    }
}
