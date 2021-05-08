import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_14171 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int length = Integer.parseInt(br.readLine());

        int [][] map = new int[26 * 26][26 * 26];

        int counter = 0;

        Queue<Pos> q = new ArrayDeque<>();

        for(int i = 0 ; i < length; i ++) {
            st = new StringTokenizer(br.readLine());

            int x = translate(st.nextToken());
            int y = translate(st.nextToken());

            if(map[x][y] == 0 && map[y][x] == 0 && x != y) {
                q.add(new Pos(x, y));
            } else if(x == y) {
                continue;
            }
            map[x][y] += 1;
        }

        for(Pos p : q) {
            counter += (map[p.x][p.y] * map[p.y][p.x]);
        }
        System.out.println(counter);
    }

    static int translate(String target) {
        return ((target.charAt(0) - 'A') * 26) + (target.charAt(1) - 'A');
    }

    static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
