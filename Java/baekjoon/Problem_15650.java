import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_15650 {
    static int N, M;
    static boolean[] visited;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        sb = new StringBuilder();

        visited = new boolean[N];
        arr = new int[M];
        dfs(0, 1);
        System.out.println(sb.toString());
    }

    private static void dfs(int count, int start) {
        if (count == M) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            arr[count] = i;
            dfs(count + 1, i + 1);
        }
    }
}
