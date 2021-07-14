import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        int[][] map = new int[n][m];

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Math.min(map[i][j], min);
                max = Math.max(map[i][j], max);
            }
        }

        int needBlock, time;
        int minTime = Integer.MAX_VALUE, minHeight = 257;
        do {
            needBlock = 0;
            time = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (max > map[i][j]) {
                        time += (max - map[i][j]);
                        needBlock += (max - map[i][j]);
                    } else if (max < map[i][j]) {
                        time += ((map[i][j] - max) * 2);
                        needBlock -= (map[i][j] - max);
                    }
                }
            }
            if(b >= needBlock) {
                if(minTime > time) {
                    minTime = time;
                    minHeight = max;
                }
            }
            max -= 1;

        } while(max >= 0);

        System.out.println(minTime + " " + minHeight);
    }
}
