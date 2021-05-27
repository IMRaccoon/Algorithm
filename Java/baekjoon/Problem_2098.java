import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2098 {
    static int n;
    static int [][] dp;
    static int length;
    static int [][] map;
    static int INF = 17_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        length = (1 << n) - 1;
        dp = new int[n][length + 1];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0){
                    map[i][j] = INF;
                }
            }
        }
        System.out.println(dfs(0, 1));
    }

    private static int dfs(int cur, int visited) {
        if(dp[cur][visited] != 0) {
            return dp[cur][visited];
        }
        if(visited == length) {
            return map[cur][0];
        }

        int weight = INF;
        for(int i = 0 ; i < n; i++) {
            if((map[cur][i] == INF) || (visited & (1 << i)) != 0) continue;
            weight = Math.min(weight, dfs(i, visited | (1 << i)) + map[cur][i]);
        }
        return dp[cur][visited] = weight;
    }
}
