import java.io.*;
import java.util.*;

public class Problem_12969 {
    static int N, K;
    static char[] arr;
    static boolean[][][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new char[N];
        visited = new boolean[31][31][31][451];

        bw.write(recursive(0, 0, 0, 0) ? String.valueOf(arr) : "-1");
        bw.flush();
    }

    private static boolean recursive(int n, int a, int b, int sum) {
        if (n == N) return sum == K;
        if (visited[n][a][b][sum]) return false;
        visited[n][a][b][sum] = true;

        arr[n] = 'A';
        if (recursive(n + 1, a + 1, b, sum)) return true;
        arr[n] = 'B';
        if (recursive(n + 1, a, b + 1, sum + a)) return true;
        arr[n] = 'C';
        if (recursive(n + 1, a, b, sum + a + b)) return true;

        return false;
    }
}
