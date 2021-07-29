import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_16118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<Road>[][] roads = new ArrayList[N + 1][3];
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 3; j++) {
                roads[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            roads[s][0].add(new Road(e, d * 2));
            roads[e][0].add(new Road(s, d * 2));
            roads[s][1].add(new Road(e, d * 4));
            roads[e][1].add(new Road(s, d * 4));
            roads[s][2].add(new Road(e, d));
            roads[e][2].add(new Road(s, d));
        }
        int[] fox = new int[N + 1];
        Arrays.fill(fox, Integer.MAX_VALUE);
        int[][] wolf = new int[2][N + 1];
        Arrays.fill(wolf[0], Integer.MAX_VALUE);
        Arrays.fill(wolf[1], Integer.MAX_VALUE);

        PriorityQueue<Pos> q = new PriorityQueue<>();
        fox[1] = 0;
        q.offer(new Pos(1, 0));


        while (!q.isEmpty()) {
            Pos pos = q.poll();
            if (pos.weight > fox[pos.cur]) continue;
            for (Road r : roads[pos.cur][0]) {
                if (fox[r.dest] > fox[pos.cur] + r.distance) {
                    fox[r.dest] = fox[pos.cur] + r.distance;
                    q.offer(new Pos(r.dest, fox[r.dest]));
                }
            }
        }

        q = new PriorityQueue<>();
        wolf[0][1] = 0;
        q.offer(new Pos(1, 0, true));

        while (!q.isEmpty()) {
            Pos pos = q.poll();
            if (pos.weight > wolf[pos.isFast ? 0 : 1][pos.cur]) continue;
            if (pos.isFast) {
                for (Road r : roads[pos.cur][2]) {
                    if (wolf[0][pos.cur] + r.distance < wolf[1][r.dest]) {
                        wolf[1][r.dest] = wolf[0][pos.cur] + r.distance;
                        q.offer(new Pos(r.dest, wolf[1][r.dest], false));
                    }
                }
            } else {
                for (Road r : roads[pos.cur][1]) {
                    if (wolf[1][pos.cur] + r.distance < wolf[0][r.dest]) {
                        wolf[0][r.dest] = wolf[1][pos.cur] + r.distance;
                        q.offer(new Pos(r.dest, wolf[0][r.dest], true));
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if (fox[i] < Math.min(wolf[0][i], wolf[1][i])) answer += 1;
        }
        System.out.println(answer);
    }

    private static class Pos implements Comparable<Pos> {
        int cur;
        int weight;
        boolean isFast;

        Pos(int cur, int weight) {
            this.cur = cur;
            this.weight = weight;
            this.isFast = false;
        }

        Pos(int cur, int weight, boolean isFast) {
            this.cur = cur;
            this.weight = weight;
            this.isFast = isFast;
        }

        @Override
        public int compareTo(Pos pos) {
            return this.weight - pos.weight;
        }
    }

    private static class Road {
        int dest;
        int distance;

        Road(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }
}