import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.List;

public class Problem_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final List<String> chars = Arrays.asList(br.readLine().split(""));
        if(chars.size() == 0) {
            System.out.println(0);
            return;
        }

        int[] numbers = chars.stream().mapToInt(Integer::parseInt).toArray();
        int length = numbers.length;
        int[] dp = new int[length];

        if(numbers[0] == 0){
            System.out.println(0);
            return;
        }
        dp[0] = 1;

        if(length > 1) {
            if(numbers[1] == 0) {
                if((numbers[0] * 10) + numbers[1] < 27) {
                    dp[1] = 1;
                }
                else {
                    System.out.println(0);
                    return;
                }
            } else {
                dp[1] = 1;
                if ((numbers[0] * 10) + numbers[1] < 27) {
                    dp[1] += 1;
                }
            }
        }

        int prev = length > 1 ? numbers[1] * 10 : 0;
        for(int i = 2; i < length; i ++) {
            int combine = prev + numbers[i];
            if (numbers[i] == 0) {
                if (combine < 27 && combine >= 10) {
                    dp[i] = dp[i - 2];
                } else {
                    dp[length - 1] = 0;
                    break;
                }
            } else {
                dp[i] = dp[i - 1];
                if (combine < 27 && combine > 10) {
                    dp[i] = (dp[i] + dp[i - 2]) % 1000000;
                }
            }
            prev = numbers[i] * 10;
        }

        System.out.println(dp[length - 1]);
    }
}

