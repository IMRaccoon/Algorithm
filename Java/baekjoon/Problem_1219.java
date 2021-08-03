import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        final int INF = -100000000;
        int N = Integer.parseInt(st.nextToken()), start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        ArrayList<Pair>[] road = new ArrayList[N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), p = Integer.parseInt(st.nextToken());
            if (road[s] == null) road[s] = new ArrayList<>();
            road[s].add(new Pair(e, p));
        }
        int[] earn = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            earn[i] = Integer.parseInt(st.nextToken());
        }
        long[] visited = new long[N];
        Arrays.fill(visited, INF);
        visited[start] = earn[start];

        ArrayDeque<Integer> cycle = new ArrayDeque<>();
        boolean [] loopCheck = new boolean[N];
        for (int loop = 1; loop <= N; loop++) {
            for (int s = 0; s < N; s++) {
                if (road[s] == null) continue;
                for (Pair p : road[s]) {
                    if (visited[s] != INF && visited[p.dest] < p.price + earn[p.dest] + visited[s]) {
                        visited[p.dest] = p.price + earn[p.dest] + visited[s];
                        if (loop == N) {
                            cycle.offer(s);
                            loopCheck[s] = true;
                        }
                    }
                }
            }
        }
        if (visited[end] == INF) {
            System.out.println("gg");
            return;
        }


        while(!cycle.isEmpty()) {
            int cur = cycle.poll();
            if(road[cur] == null) continue;
            for(Pair p : road[cur]) {
                if(loopCheck[p.dest]) continue;
                loopCheck[p.dest] = true;
                cycle.offer(p.dest);
            }
        }


        if (loopCheck[end]) {
            System.out.println("Gee");
        } else {
            System.out.println(visited[end]);
        }
    }

    private static class Pair {
        int dest;
        int price;

        Pair(int dest, int price) {
            this.dest = dest;
            this.price = -price;
        }
    }
}

