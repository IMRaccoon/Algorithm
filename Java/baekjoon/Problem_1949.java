import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_1949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] population = new int[N + 1];
        ArrayList<Integer>[] road = new ArrayList[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            road[i] = new ArrayList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            road[first].add(second);
            road[second].add(first);
        }
        int [][] dp = new int[N + 1][2];
        dp[1][0] = population[1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 2; i <= N; i++) {
            dp[i][0] = population[i];
            if(road[i].size() == 1) q.offer(i);
        }

        while(!q.isEmpty()) {
            Integer cur = q.poll();
            for(int next: road[cur]) {
                dp[next][0] += dp[cur][1];
                dp[next][1] += Math.max(dp[cur][1], dp[cur][0]);
                road[next].remove(cur);
                if(next != 1 && road[next].size() == 1) q.offer(next);
            }
        }
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}