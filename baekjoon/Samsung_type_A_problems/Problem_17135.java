package Samsung_type_A_problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/** 규칙 1. 게임이 진행되는 곳은 크기가 N×M인 격자판으로 나타낼 수 있다. 격자판은 1×1 크기의 칸으로 나누어져 있고, 각 칸에 포함된 적의 수는 최대 하나이다.
 *  규칙 2. 성을 적에게서 지키기 위해 궁수 3명을 배치하려고 한다. 궁수는 성이 있는 칸에 배치할 수 있고, 하나의 칸에는 최대 1명의 궁수만 있을 수 있다.
 *  규칙 3. 각각의 턴마다 궁수는 적 하나를 공격할 수 있고, 모든 궁수는 동시에 공격한다.
 *  규칙 4. 궁수가 공격하는 적은 거리가 D 이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다.
 *  규칙 5. 같은 적이 여러 궁수에게 공격당할 수 있다.
 *  규칙 6. 공격받은 적은 게임에서 제외된다. 궁수의 공격이 끝나면, 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다.
 *  규칙 7. 격자판의 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|이다.
 */
public class Problem_17135 {
    static int n;
    static int m;
    static int distance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        int map[][] = new int[n+1][m];
        int enemyCount = 0;
        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());     // if it has monster, save 1, or 0
                if(map[i][j] == 1) enemyCount += 1;
            }
        }

    }

    public int simulation(int[][] map, int enemyCount, int answer) {
        // attack from archer
        for(int i = 0; i< m; i++) {
            if(map[n][i] == -1) {
                if(killEnemy(map, i)) answer += 1;
            }
        }

        // enemies come to castle
        if(enemyCount == 0)
            return answer;
        else {

            return simulation(map, enemyCount, answer);
        }
    }

    public boolean killEnemy(int[][] map,  int x) {
        int shortestX;
        int shortestY;
        int dist = distance;
        for(int i = 1; i < distance; i++) {
            for(int j = 0; j <= distance-i; j++) {
                if(map[n-i][x-j] != 0) {
                    if(dist < i+j) {
                        map[n-i][x-j] += 1;
                        dist = i + j;
                        shortestX = n-i;
                        shortestY = x-j;
                    }
                }
                if(map[n-i][x+j] != 0) {
                    if(dist < i+j) {
                        map[n-i][x+j] += 1;
                        dist = i + j;
                    }
                }
            }
        }
        return false;
    }
}
