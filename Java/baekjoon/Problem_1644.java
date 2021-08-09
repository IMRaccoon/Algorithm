import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem_1644 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        boolean[] map = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            if (map[i]) continue;
            for (int j = 2; i * j <= N; j++) {
                map[i * j] = true;
            }
        }

        int size, answer = 0;
        for (int i = 2; i < N; i++) {
            if (map[i]) continue;
            size = q.size();
            for (int j = 0; j < size; j++) {
                int poll = q.poll();
                if (poll + i == N) answer += 1;
                else if (poll + i < N) q.offer(poll + i);
            }
            q.offer(i);
        }

        if(N > 1 && !map[N]) answer += 1;
        System.out.println(answer);
    }
}
