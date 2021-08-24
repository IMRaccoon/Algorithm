import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_1799 {
    static int[][] map;
    static int N;
    static ArrayList<Pair> even, odd;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        even = new ArrayList<>();
        odd = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().equals("1") ? 0 : N;
                if (map[i][j] == 0) {
                    if ((i + j) % 2 == 0) even.add(new Pair(i, j));
                    else odd.add(new Pair(i, j));
                }
            }
        }
        System.out.println(recursive(true, 0) + recursive(false, 0));
    }

    private static int recursive(boolean isEven, int index) {
        int count = 0;
        Pair cur;
        if (isEven) {
            if (index == even.size()) return 0;
            cur = even.get(index);
        } else {
            if (index == odd.size()) return 0;
            cur = odd.get(index);
        }

        if (map[cur.n][cur.m] == 0) {
            calculate(cur.n, cur.m, true);
            count = Math.max(count, 1 + recursive(isEven, index + 1));
            calculate(cur.n, cur.m, false);
            count = Math.max(count, recursive(isEven, index + 1));
            return count;
        }
        return recursive(isEven, index + 1);
    }

    private static void calculate(int n, int m, boolean isAdd) {
        for (int i = 0; i < N; i++) {
            if (m + n - i >= 0 && m + n - i < N) map[i][m + n - i] += isAdd ? 1 : -1;
            if (m + i - n >= 0 && m + i - n < N) map[i][m + i - n] += isAdd ? 1 : -1;
        }
        map[n][m] += isAdd ? -1 : 1;
    }

    private static class Pair {
        int n, m;

        Pair(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}

