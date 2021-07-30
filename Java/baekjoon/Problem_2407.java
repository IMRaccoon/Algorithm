import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem_2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        M = Math.min(M, N - M);

        BigInteger sum = new BigInteger("1");

        for(int i = N - M + 1; i <= N; i++) {
            sum = sum.multiply(new BigInteger(String.valueOf(i)));
            sum = sum.divide(new BigInteger(String.valueOf(i - N + M)));
        }
        System.out.println(sum);
    }
}
