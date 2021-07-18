import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem_11279 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());

        int n = Integer.parseInt(br.readLine());
        int x;
        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(q.isEmpty()) {
                    bw.write("0");
                } else {
                    bw.write(String.valueOf(q.poll()));
                }
                bw.newLine();
            } else {
                q.offer(x);
            }
        }
        bw.flush();
    }
}
