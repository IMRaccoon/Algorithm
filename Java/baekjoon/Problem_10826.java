import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem_10826 {
    static BigInteger[] origin;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        origin = new BigInteger[]{new BigInteger("1"), new BigInteger("1"), new BigInteger("1"), new BigInteger("0")};
        if(N == 0) System.out.println(0);
        else {
            BigInteger[] answer = pow(origin, N);
            System.out.println(answer[1]);
        }
    }

    private static BigInteger[] pow(BigInteger[] matrix, int length) {
        if (length == 1) return matrix;
        BigInteger[] res = pow(matrix, length / 2);
        res = multiply(res, res);
        if (length % 2 == 1) res = multiply(res, origin);
        return res;
    }

    private static BigInteger[] multiply (BigInteger[] o1, BigInteger[] o2) {
        BigInteger [] res = new BigInteger[4];
        res[3] = o1[2].multiply(o2[1]).add(o1[3].multiply(o2[3]));
        res[2] = o1[2].multiply(o2[0]).add(o1[3].multiply(o2[2]));
        res[1] = res[2];
        res[0] = res[2].add(res[3]);
        return res;
    }
}
