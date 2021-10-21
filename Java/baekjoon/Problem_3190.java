import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_3190 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        // 오른쪽, 아래, 왼쪽, 위 ->  D => +1, L => -1
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int N = Integer.parseInt(br.readLine());
        boolean[][] map = new boolean[N][N];
        int K = Integer.parseInt(br.readLine());


        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            map[Integer.parseInt(input[0]) - 1][Integer.parseInt(input[1]) - 1] = true;
        }

        int L = Integer.parseInt(br.readLine());
        ArrayDeque<Move> history = new ArrayDeque<>();
        for (int i = 0; i < L; i++) {
            input = br.readLine().split(" ");
            history.add(new Move(Integer.parseInt(input[0]), input[1].equals("D")));
        }

        int time = 0, dir = 0, nextN, nextM, originN, originM;
        ArrayDeque<Tail> tails = new ArrayDeque<>();
        tails.add(new Tail(0, 0));
        HashSet<Integer> checkCollision = new HashSet<>();
        checkCollision.add(0);

        while (true) {
            if (!history.isEmpty() && history.peek().time == time) {
                if (history.poll().isRight) dir = (dir + 1) % 4;
                else dir = (dir + 3) % 4;
            }

            Tail head = tails.getLast();
            nextN = head.n + dirs[dir][0];
            nextM = head.m + dirs[dir][1];
            
            time += 1;
            if (nextN < 0 || nextN >= N || nextM < 0 || nextM >= N || checkCollision.contains(nextN * N + nextM)) break;
            tails.add(new Tail(nextN, nextM));
            checkCollision.add(nextN * N + nextM);
            if (!map[nextN][nextM]) {
                Tail tmp = tails.poll();
                checkCollision.remove(tmp.n * N + tmp.m);
            } else map[nextN][nextM] = false;
        }
        System.out.println(time);
    }

    private static class Tail {
        int n, m;

        Tail(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }

    private static class Move {
        int time;
        boolean isRight;

        Move(int time, boolean isRight) {
            this.time = time;
            this.isRight = isRight;
        }
    }
}
