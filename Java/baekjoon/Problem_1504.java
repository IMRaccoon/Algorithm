import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1504 {
    static int n;
    static ArrayList<Route> [] map;
    static PriorityQueue<Route> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        map = new ArrayList[n+1];
        for(int i = 1 ; i <= n; i++) {
            map[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < e; i++) {
            st = new StringTokenizer(br.readLine());

            int r1 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[r1].add(new Route(r2, weight));
            map[r2].add(new Route(r1, weight));
        }

        st = new StringTokenizer(br.readLine());
        int visitFirst = Integer.parseInt(st.nextToken());
        int visitSecond = Integer.parseInt(st.nextToken());

        int firstCase = dijkstra(1, visitFirst) + dijkstra(visitFirst, visitSecond) + dijkstra(visitSecond, n);
        int secondCase = dijkstra(1, visitSecond) + dijkstra(visitSecond, visitFirst) + dijkstra(visitFirst, n);

        if(firstCase > 200000000 && secondCase > 200000000) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(firstCase, secondCase));
        }
    }

    private static int dijkstra(int start, int end) {
        if(start == end) return 0;
        queue = new PriorityQueue<>();
        queue.add(new Route(start, 0));
        int [] save = new int[n+1];
        Arrays.fill(save, 200000001);

        while(!queue.isEmpty()) {
            Route cur = queue.poll();

            for(Route r : map[cur.dest]) {
                if(save[r.dest] > cur.weight + r.weight) {
                    queue.add(new Route(r.dest, cur.weight + r.weight));
                    save[r.dest] = cur.weight + r.weight;
                }
            }
        }

        return save[end];
    }

    private static class Route implements Comparable<Route>{
        int dest;
        int weight;

        Route(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Route route) {
            return this.weight - route.weight;
        }
    }
}
