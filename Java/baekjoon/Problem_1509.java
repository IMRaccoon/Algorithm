import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1509 {
    static char[] arr;
    static int length;
    static boolean[][] dp;
    static int[] saved;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = br.readLine().toCharArray();
        length = arr.length;
        saved = new int[length];
        dp = new boolean[length][length];

        for (int i = 0; i < length; i++) dp[i][i] = true;
        for (int i = 1; i < length; i++) dp[i - 1][i] = arr[i - 1] == arr[i];

        for (int len = 2; len < length; len++) {
            for (int start = 0; start + len < length; start++) {
                int end = start + len;
                if (arr[start] == arr[end] && dp[start + 1][end - 1]) dp[start][end] = true;
            }
        }

        for (int end = 0; end < length; end++) {
            saved[end] = Integer.MAX_VALUE;
            for (int start = 0; start <= end; start++) {
                if (dp[start][end]) {
                    saved[end] = Math.min(saved[end], start == 0 ? 1 : saved[start - 1] + 1);
                }
            }
        }
        System.out.println(saved[length - 1]);
    }
}
