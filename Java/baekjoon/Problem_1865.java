import java.io.*;
import java.util.*;

public class Problem_1865 {
    static HashMap<Integer, Integer>[] road;
    final static int INF = 500_0000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int N, M, W, start, end, time;

        while (T-- != 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            road = new HashMap[N + 1];
            for (int i = 1; i <= N; i++) {
                road[i] = new HashMap<>();
            }

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());
                addRoad(start, end, time);
                addRoad(end, start, time);
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                start = Integer.parseInt(st.nextToken());
                end = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());
                addRoad(start, end, -time);
            }

            boolean isNegativeCycle = false;
            int[] dist = new int[N + 1];

            Arrays.fill(dist, INF);
            dist[1] = 0;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    for (Map.Entry<Integer, Integer> entry : road[j].entrySet()) {
                        if (dist[entry.getKey()] > dist[j] + entry.getValue()) {
                            dist[entry.getKey()] = dist[j] + entry.getValue();
                            if (i == N) {
                                isNegativeCycle = true;
                                break;
                            }
                        }
                    }
                }
            }

            bw.write(isNegativeCycle ? "YES" : "NO");
            bw.newLine();
        }
        bw.flush();
    }

    private static void addRoad(int start, int end, int time) {
        Integer tmp = road[start].get(end);
        if (tmp == null || tmp > time) {
            road[start].put(end, time);
        }
    }
}
