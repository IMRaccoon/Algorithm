import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1018 {
    static boolean [][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        map = new boolean[n][m];

        for(int i = 0 ; i < n; i++) {
            char [] arr = br.readLine().toCharArray();
            for(int j = 0; j < m; j++) {
                map[i][j] = arr[j] == 'W';
            }
        }

        int minArea = 64;

        for(int i = 0 ; i <= n - 8; i++) {
            for(int j = 0 ; j <= m - 8; j++) {
                minArea = Math.min(minArea, countWrongTile(i, j));
                if(minArea == 0) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(minArea);
    }

    public static int countWrongTile(int n, int m) {
        int counter = 0;

        for (int i = n; i < n + 8; i++) {
            for(int j = m; j < m + 8; j++) {
                if(map[i][j] != ((i + j) % 2 == 0)) {
                    counter ++;
                }
            }
        }

        return Math.min(counter, 64 - counter);
    }
}
