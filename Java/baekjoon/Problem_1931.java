import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Meet> q = new PriorityQueue<>();

        int start, end;
        int last = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            last = Math.max(last, end);
            q.offer(new Meet(start, end));
        }

        Meet cur;
        int count = 0, ended = -1;
        while (!q.isEmpty()) {
            cur = q.poll();
            if (ended <= cur.start) {
                count += 1;
                ended = cur.end;
            }
        }
        System.out.println(count);
    }

    private static class Meet implements Comparable<Meet> {
        int start, end;

        Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meet meet) {
            if (end == meet.end) {
                return start - meet.start;
            }
            return end - meet.end;
        }
    }
}
