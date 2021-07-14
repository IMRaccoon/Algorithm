import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1012 {
    static int[][] arr;
    static int dir = 4;
    static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine()), k;

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            arr = new int[m][n];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -1;
            }

            int counter = 0;
            for (int a = 0; a < m; a++) {
                for (int b = 0; b < n; b++) {
                    if(arr[a][b] == -1) {
                        arr[a][b] = ++counter;
                        dfs(a, b);
                    }
                }
            }
            System.out.println(counter);
        }
    }

    private static void dfs(int m1, int n1) {
        for(int i = 0 ; i < dir; i++) {
            if(m1 + dirs[i][0] >= 0 && m1 + dirs[i][0] < m && n1 + dirs[i][1] >= 0 && n1 + dirs[i][1] < n) {
                if(arr[m1 + dirs[i][0]][n1 + dirs[i][1]] == -1) {
                    arr[m1 + dirs[i][0]][n1 + dirs[i][1]] = arr[m1][n1];
                    dfs(m1 + dirs[i][0], n1 + dirs[i][1]);
                }
            }
        }
    }
}
