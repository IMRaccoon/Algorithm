import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14889 {
    static int[][] arr;
    static int[] first, second;
    static int N, limit, firstIndex, secondIndex;
    static boolean[] team;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        limit = N / 2;
        arr = new int[N][N];
        team = new boolean[N];
        first = new int[limit];
        second = new int[limit];
        String[] input;

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(recursive(0, 0));
    }

    private static int recursive(int count, int index) {
        if (count == limit) {
            firstIndex = 0;
            secondIndex = 0;
            for (int i = 0; i < N; i++) {
                if (team[i]) first[firstIndex++] = i;
                else second[secondIndex++] = i;
            }
            return Math.abs(getSum(first) - getSum(second));
        }
        int tmp = Integer.MAX_VALUE;
        for (int i = index; i < N; i++) {
            team[i] = true;
            tmp = Math.min(tmp, recursive(count + 1, i + 1));
            team[i] = false;
        }
        return tmp;
    }

    private static int getSum(int[] t) {
        int res = 0;
        for (int i = 0; i < limit; i++) {
            for (int j = i + 1; j < limit; j++) {
                res += arr[t[i]][t[j]] + arr[t[j]][t[i]];
            }
        }
        return res;
    }
}