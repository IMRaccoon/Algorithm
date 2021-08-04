import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2306 {
    static int[][] dp;
    static char[] input;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        length = input.length;
        dp = new int[length][length];

        for (int r = 1; r < length; r++) {
            for (int i = 0; i < length - r; i++) {
                dp[i][i + r] = (checkIsPair(input[i], input[i + r]) ? 2 : 0) + dp[i + 1][i + r - 1];
                dp[i][i + r] = Math.max(dp[i][i + r], Math.max(dp[i][i + r - 1], dp[i + 1][i + r]));
                for (int j = 1; j < r - 1; j++) {
                    dp[i][i + r] = Math.max(dp[i][i + r], dp[i][i + j] + dp[i + j + 1][i + r]);
                }
            }
        }
        System.out.println(dp[0][length-1]);
    }

    private static boolean checkIsPair(char first, char second) {
        if(first == 'a' && second == 't') return true;
        if(first == 'g' && second == 'c') return true;
        return false;
    }
}

