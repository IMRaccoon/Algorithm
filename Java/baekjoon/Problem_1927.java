import java.io.*;
import java.util.PriorityQueue;

public class Problem_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()), x;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (q.size() == 0) {
                    bw.write(0 + "\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else {
                q.offer(x);
            }
        }
        bw.flush();
    }
}
