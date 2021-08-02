import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), R = Integer.parseInt(st.nextToken());
        int[][] map = new int[N + 1][N + 1];
        st = new StringTokenizer(br.readLine());

        int[] items = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], 1501);
            map[i][i] = 0;
            items[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()), second = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            map[first][second] = Math.min(length, map[first][second]);
            map[second][first] = map[first][second];
        }

        int [][] range = new int[N + 1][N + 1];
        for(int k = 1; k <= N; k++) {
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    if(map[i][j] <= M) {
                        range[i][j] = items[j];
                    }
                }
            }
        }
        int max = 0;
        for(int i = 1; i <= N; i++) {
            int tmp = 0;
            for(int j = 1; j <= N; j++) {
                tmp += range[i][j];
            }
            max = Math.max(tmp, max);
        }
        System.out.println(max);
    }
}
