import java.io.*;
import java.util.*;

public class Problem_10217 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int N, M, K, u, v, c, d, nextCost, nextTime;

        while (T-- != 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            ArrayList<Flight>[] routes = new ArrayList[N + 1];
            int [][] visitCostTime = new int[N + 1][M + 1];
            for (int i = 1; i <= N; i++) {
                routes[i] = new ArrayList<>();
                Arrays.fill(visitCostTime[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                u = Integer.parseInt(st.nextToken());
                v = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                if (u == v) continue;
                routes[u].add(new Flight(v, c, d));
            }

            PriorityQueue<Flight> queue = new PriorityQueue<>();
            queue.offer(new Flight(1, 0, 0));

            Flight cur;
            int arrive = Integer.MAX_VALUE;
            visitCostTime[1][0] = 0;

            while (!queue.isEmpty()) {
                cur = queue.poll();
                if(cur.pos == N) {
                    arrive = cur.time;
                    break;
                }
                for (Flight next : routes[cur.pos]) {
                    nextCost = cur.cost + next.cost;
                    nextTime = cur.time + next.time;
                    if (nextCost > M) continue;
                    if (visitCostTime[next.pos][nextCost] <= nextTime) continue;
                    for (int i = nextCost; i <= M; i++) {
                        if (visitCostTime[next.pos][i] <= nextTime) break;
                        visitCostTime[next.pos][i] = nextTime;
                    }
                    queue.offer(new Flight(next.pos, nextCost, nextTime));
                }
            }
            bw.write(arrive == Integer.MAX_VALUE ? "Poor KCM\n" : arrive + "\n");
        }
        bw.flush();
    }

    private static class Flight implements Comparable<Flight> {
        int pos, cost, time;

        Flight(int pos, int cost, int time) {
            this.pos = pos;
            this.cost = cost;
            this.time = time;
        }

        @Override
        public int compareTo(Flight flight) {
            return this.time == flight.time ? this.cost - flight.cost : this.time - flight.time;
        }
    }
}