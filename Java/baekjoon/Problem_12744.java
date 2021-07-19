import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_12744 {
    static int N;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[654322][64];
        StringTokenizer st;
        int[] cakes = new int[N + 1];
        boolean[] status = new boolean[N + 1];
        for (int order = 1; order <= N; order++) {
            st = new StringTokenizer(br.readLine());
            cakes[order] = Integer.parseInt(st.nextToken());
            status[order] = st.nextToken().equals("+");
        }

        ArrayDeque<Pair> map = new ArrayDeque<>();
        Pair next;
        map.add(new Pair(cakes, status));
        int answer = 0, size = 1;
        int standard;

        while (!map.isEmpty()) {
            Pair cur = map.poll();
            standard = check(cur.newCakes, cur.newStatus);
            if (standard != 0) {
                for (int n = 1; n <= N; n++) {
                    next = flip(n, cur.newCakes.clone(), cur.newStatus.clone());
                    if (next != null) {
                        map.offer(next);
                    }
                }
            } else {
                System.out.println(answer);
                return;
            }

            if (--size == 0) {
                answer += 1;
                size = map.size();
            }
        }
    }

    private static Pair flip(int n, int[] cakes, boolean[] status) {
        int tempCake;
        boolean tempStatus;
        for (int i = 1; i <= (n / 2); i++) {
            tempCake = cakes[i];
            cakes[i] = cakes[n - i + 1];
            cakes[n - i + 1] = tempCake;
            tempStatus = status[i];
            status[i] = !status[n - i + 1];
            status[n - i + 1] = !tempStatus;
        }
        if (n % 2 == 1) {
            status[(n / 2) + 1] = !status[(n / 2) + 1];
        }

        int c = cakes[1], s = status[1] ? 1 : 0;
        for (int i = 2; i <= N; i++) {
            c = (c * 10) + cakes[i];
            s = (s << 1) + (status[i] ? 1 : 0);
        }

        if (!visited[c][s]) {
            visited[c][s] = true;
            return new Pair(cakes, status);
        }
        return null;
    }

    private static int check(int[] newCakes, boolean[] newStatus) {
        for (int i = N; i >= 1; i--) {
            if (newCakes[i] != i || !newStatus[i]) {
                return i;
            }
        }
        return 0;
    }

    private static class Pair {
        int[] newCakes;
        boolean[] newStatus;

        Pair(int[] newCakes, boolean[] newStatus) {
            this.newCakes = newCakes;
            this.newStatus = newStatus;
        }

        @Override
        public boolean equals(Object a) {
            Pair p = (Pair) a;
            for (int i = 1; i <= N; i++) {
                if ((newCakes[i] != p.newCakes[i]) || (newStatus[i] != p.newStatus[i])) return false;
            }
            return true;
        }
    }
}
