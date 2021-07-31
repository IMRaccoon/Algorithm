import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_15654 {
    static int [] origin;
    static boolean [] visited;
    static int [] arr;
    static int N, M;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        origin = new int[N];
        arr = new int[M];
        visited = new boolean[N];
        sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(origin);

        dfs(0);
        System.out.print(sb.toString());
    }

    private static void dfs(int count) {
        if(count == M) {
            for(int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            arr[count] = origin[i];
            dfs(count + 1);
            visited[i] = false;
        }
    }
}
