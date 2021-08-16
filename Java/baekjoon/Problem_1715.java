import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>();
        long answer = 0;
        for (int i = 0; i < N; i++) {
            q.offer(Integer.parseInt(br.readLine()));
        }
        int sum;
        while(q.size() > 1) {
            int first = q.poll();
            int second = q.poll();
            sum = first + second;
            q.offer(sum);
            answer += sum;
        }
        System.out.println(answer);
    }
}
