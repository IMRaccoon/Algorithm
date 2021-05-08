import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14503 {
    static int[][] map;
    static int n, m;
    static final int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        st = new StringTokenizer(br.readLine());
        int robotY = Integer.parseInt(st.nextToken());
        int robotX = Integer.parseInt(st.nextToken());
        int robotDir = Integer.parseInt(st.nextToken());

        // 1 면 방, 0 면 벽
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) == 0 ? 1 : 0;
            }
        }

        System.out.println(recursive(robotY, robotX, robotDir));
    }


    public static int recursive(int y, int x, int startDir) {
        map[y][x] = 2;

        for(int i = 1; i <= 4; i++) {
            int tmpDir = (Math.abs(4 + startDir - i)) % 4;
            int[] check = dir[tmpDir];

            if (y + check[0] < 0 || y + check[0] >= n || x + check[1] < 0 || x + check[1] >= m) {
                continue;
            }

            if(map[y + check[0]][x + check[1]] == 1) {
                return 1 + recursive(y + check[0], x + check[1], tmpDir);
            }
        }

        int [] nextDir = dir[(startDir + 2) % 4];
        if(map[y + nextDir[0]][x + nextDir[1]] == 0) {
            return 1;
        }
        return recursive(y + nextDir[0], x + nextDir[1], startDir);
    }
}
