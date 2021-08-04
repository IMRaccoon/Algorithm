import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1197 {
    static int [] linked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        linked = new int[V + 1];
        int size = 0;
        PriorityQueue<Road> q = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            q.offer(new Road(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int answer = 0;
        while (!q.isEmpty()) {
            Road cur = q.poll();

            if (linked[cur.s] == 0 && linked[cur.e] == 0) {
                linked[cur.s] = linked[cur.e] = Math.min(cur.s, cur.e);
                size += 1;
                answer += cur.d;
            } else if (linked[cur.s] == 0) {
                linked[cur.s] = findRoot(cur.e);
                size += 1;
                answer += cur.d;
            } else if (linked[cur.e] == 0) {
                linked[cur.e] = findRoot(cur.s);
                size += 1;
                answer += cur.d;
            } else {
                int start = findRoot(cur.s);
                int end = findRoot(cur.e);
                if (start != end) {
                    linked[start] = linked[end] = Math.min(start, end);
                    size += 1;
                    answer += cur.d;
                }
            }
            if(size == V - 1) break;
        }
        System.out.println(answer);
    }

    private static int findRoot(int index) {
        if(linked[index] == index) {
            return index;
        }
        return findRoot(linked[index]);
    }

    private static class Road implements Comparable<Road>{
        int s, e, d;

        Road(int s, int e, int d) {
            this.s = s;
            this.e = e;
            this.d = d;
        }

        @Override
        public int compareTo(Road road) {
            return this.d - road.d;
        }
    }
}
