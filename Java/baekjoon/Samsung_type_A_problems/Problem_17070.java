package Samsung_type_A_problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 규칙 1. 파이프를 밀 수 있는 방향은 총 3가지가 있으며, →, ↘, ↓ 방향이다.
 *  규칙 2. 파이프는 밀면서 회전시킬 수 있다. 회전은 45도만 회전시킬 수 있으며, 미는 방향은 오른쪽, 아래, 또는 오른쪽 아래 대각선 방향이다.
 *  규칙 3. 파이프가 가로로 놓여진 경우에 가능한 이동 방법은 총 2가지, 세로로 놓여진 경우에는 2가지, 대각선 방향으로 놓여진 경우에는 3가지가 있다.
 */
public class Problem_17070 {
    static boolean map[][];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j< n ;j++) {
                map[i][j] = st.nextToken().equals("1");
            }
        }
        br.close();
        recursive(0, 1, true, false, n-1);
        System.out.println(answer);
    }

    public static void recursive(int x, int y, boolean goHorizontal, boolean goVertical, int n) {
        if(x == n && y == n) {
            answer += 1;
            return;
        }
        if(y+1 <= n && goHorizontal && !map[x][y+1]) {
            recursive(x, y+1, true, false, n);
        }
        if(x+1 <= n && goVertical && !map[x+1][y]) {
            recursive(x+1, y, false, true, n);
        }
        if(x+1 <= n && y+1 <= n && !map[x+1][y] && !map[x][y+1] && !map[x+1][y+1]) {
            recursive(x+1, y+1, true, true, n);
        }
    }
}
