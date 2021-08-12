import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1810 {
    static double[] calculated = new double[]{1, 2, Math.sqrt(2), Math.sqrt(5), Math.sqrt(8)};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), F = Integer.parseInt(st.nextToken()) + 1;

        HashMap<Long, Double> arr = new HashMap<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) + 1, y = Integer.parseInt(st.nextToken()) + 1;
            arr.put(makeKey(x, y), Double.MAX_VALUE);
        }
        arr.replace(makeKey(1, 1), 0d);
        PriorityQueue<Pos> q = new PriorityQueue<>(Comparator.comparingDouble(p -> p.dist));
        q.offer(new Pos(1, 1, 0));

        Pos cur;
        double dist;
        long answer = Long.MAX_VALUE, key;

        while (!q.isEmpty()) {
            cur = q.poll();
            if (cur.y == F) {
                answer = Math.round(cur.dist);
                break;
            }
            for (int j = Math.min(cur.y + 2, F); j >= cur.y - 2; j--) {
                for (int i = cur.x + 2; i >= cur.x - 2; i--) {
                    if ((i == cur.x && j == cur.y) || i < 1 || j < 1 || j > F) continue;
                    key = makeKey(i, j);
                    if(!arr.containsKey(key)) continue;
                    dist = calculation(Math.abs(j - cur.y), Math.abs(i - cur.x)) + cur.dist;
                    if (arr.get(key) <= dist || dist > answer) continue;
                    arr.replace(key, dist);
                    q.offer(new Pos(i, j, dist));
                }
            }
        }
        System.out.println(answer == Long.MAX_VALUE ? -1 : answer);
    }

    private static long makeKey(int x, int y) {
        return (long) (x * 1_000_000) + y;
    }

    private static double calculation(int diff1, int diff2) {
        if (diff1 == 0 || diff2 == 0) {
            return calculated[Math.max(diff1, diff2) - 1];
        }
        return calculated[diff2 + diff1];
    }

    private static class Pos  {
        double dist;
        int x, y;

        public Pos(int x, int y, double dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}