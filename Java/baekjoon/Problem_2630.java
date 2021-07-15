import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2630 {
    static boolean[][] isWhite;
    static int blue = 0, white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        isWhite = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                isWhite[i][j] = Integer.parseInt(st.nextToken()) == 0;
            }
        }
        dfs(0, 0, n);
        System.out.println(white + "\n" + blue);
    }

    private static void dfs(int startX, int startY, int index) {
        boolean start = isWhite[startX][startY];
        if (index != 1) {
            for (int i = 0; i < index; i++) {
                for (int j = 0; j < index; j++) {
                    if (start != isWhite[startX + i][startY + j]) {
                        dfs(startX, startY, index / 2);
                        dfs(startX + (index / 2), startY, index / 2);
                        dfs(startX, startY + (index / 2), index / 2);
                        dfs(startX + (index / 2), startY + (index / 2), index / 2);
                        return;
                    }
                }
            }
        }
        if (start) white += 1;
        else blue += 1;
    }
}
