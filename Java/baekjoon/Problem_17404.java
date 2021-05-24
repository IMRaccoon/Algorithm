import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class Problem_17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][3];

        // 0 R, 1 G, 2 B
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }



        int[] curMap;
        int[] prevMap;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            curMap = new int[3];

            for(int j = 0; j< 3; j++) {
                curMap[j] = map[1][j] + map[0][i];
            }
            curMap[i] = Integer.MAX_VALUE;
            prevMap = Arrays.copyOf(curMap, 3);

            for (int j = 2; j < n; j++) {
                for(int k = 0; k < 3; k++) {
                    curMap[k] = map[j][k] + Math.min(prevMap[(k + 1) % 3], prevMap[(k + 2) % 3]);
                }
                prevMap = Arrays.copyOf(curMap, 3);
            }
            for (int j = 0; j < 3; j++) {
                if (i != j) {
                    min = Math.min(min, curMap[j]);
                }
            }
        }
        System.out.println(min);
    }
}
