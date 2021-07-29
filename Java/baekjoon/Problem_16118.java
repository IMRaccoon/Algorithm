import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_16118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        ArrayList<Road>[] roads = new ArrayList[N + 1];
        ArrayList<Road>[] fastRoads = new ArrayList[N + 1];
        ArrayList<Road>[] slowRoads = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            roads[i] = new ArrayList<>();
            fastRoads[i] = new ArrayList<>();
            slowRoads[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken()), d = Integer.parseInt(st.nextToken());
            roads[s].add(new Road(e, d));
            roads[e].add(new Road(s, d));
            fastRoads[s].add(new Road(e, (float) d / 2));
            fastRoads[e].add(new Road(s, (float) d / 2));
            slowRoads[s].add(new Road(e, d * 2));
            slowRoads[e].add(new Road(s, d * 2));
        }

        ArrayDeque<Speed> q = new ArrayDeque<>();
        float[] fox = new float[N + 1];
        Arrays.fill(fox, 100_000_000_000L);
        fox[1] = 0;
        q.offer(new Speed(1, true));


        while (!q.isEmpty()) {
            Speed cur = q.poll();
            for (Road r : roads[cur.pos]) {
                if (fox[r.dest] > fox[cur.pos] + r.distance) {
                    fox[r.dest] = fox[cur.pos] + r.distance;
                }
            }

        }

        q = new ArrayDeque<>();
        float[][] wolf = new float[2][N + 1];
        Arrays.fill(wolf[0], 100_000_000_000L);
        Arrays.fill(wolf[1], 100_000_000_000L);
        wolf[0][1] = 0;
        q.offer(new Speed(1, true));

        while (!q.isEmpty()) {
            boolean isOffer = false;
            Speed cur = q.poll();
            for (Road r : roads[cur.pos]) {
                if (fox[r.dest] > fox[cur.pos] + r.distance) {
                    fox[r.dest] = fox[cur.pos] + r.distance;
                }
                if(cur.isFast) {
                    if (wolf[0][cur.pos] + ((float) r.distance / 2) < wolf[1][r.dest]) {
                        wolf[1][r.dest] = wolf[0][cur.pos] + ((float) r.distance / 2);
                        isOffer = true;
                    }
                } else {
                    if (wolf[1][cur.pos] + (r.distance * 2) < wolf[0][r.dest]) {
                        wolf[0][r.dest] = wolf[1][cur.pos] + (r.distance * 2);
                        isOffer = true;
                    }
                }
                if (isOffer) q.offer(new Speed(r.dest, !cur.isFast));
            }
        }

        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if (fox[i] < wolf[0][i] && fox[i] < wolf[1][i]) answer += 1;
        }
        System.out.println(answer);
    }

    private static class Road {
        int dest;
        float distance;

        Road(int dest, float distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }

    private static class Speed {
        boolean isFast;
        int pos;

        Speed(int pos, boolean isFast) {
            this.pos = pos;
            this.isFast = isFast;
        }
    }
}

