import java.util.Scanner;

public class Problem_2591 {
    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    public static void firstMethod() {
        Scanner scan = new Scanner(System.in);

        char[] chars = scan.next().toCharArray();
        int length = chars.length;

        int[] dp = new int[length];
        dp[0] = 1;

        int prev = (chars[0] - '0') * 10;
        if(length > 1) {
            int cur = chars[1] - '0';
            if (cur == 0) {
                dp[1] = 1;
            } else if (prev + cur < 35) {
                dp[1] = 2;
            } else {
                dp[1] = 1;
            }
            prev = cur * 10;
        }

        for (int i = 2; i < length; i++) {
            int cur = chars[i] - '0';
            int combine = prev + cur;

            if (cur == 0) {
                if (combine < 35 && combine >= 10)
                    dp[i] = dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
                if (combine < 35 && combine > 10) {
                    dp[i] += dp[i - 2];
                }
            }
            prev = cur * 10;
        }
        System.out.println(dp[length - 1]);
    }

    public static void secondMethod() {
        Scanner scan = new Scanner(System.in);

        char[] chars = scan.next().toCharArray();
        int length = chars.length;


        int[][] dp = new int[length][2];
        dp[0][0] = 1;

        int prev = (chars[0] - '0') * 10;

        for(int i = 1; i < length; i++) {
            int cur = (chars[i] - '0');
            if (cur != 0) {
                dp[i][0] = dp[i - 1][1] + dp[i - 1][0];
            }
            if (prev + cur < 35) {
                dp[i][1] = dp[i - 1][0];
            }
            prev = cur * 10;
        }
        System.out.println(dp[length-1][0] + dp[length-1][1]);
    }
}
