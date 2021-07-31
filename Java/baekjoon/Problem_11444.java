import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_11444 {
    static long DIV = 1000000007;
    static long[][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        origin = new long[][]{{1, 1}, {1, 0}};
        long N = Long.parseLong(br.readLine());
        if(N == 0) {
            System.out.println(0);
        } else {
            long[][] answer = pow(origin, N);
            System.out.println(answer[0][1] % DIV);
        }
    }

    private static long [][] pow(long [][] matrix, long length) {
        if(length == 1) return matrix;
        long [][] res = pow(matrix, length / 2);
        res = multiply(res, res);
        if(length % 2 == 1) res = multiply(res, origin);
        return res;
    }



    private static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] res = new long[2][2];
        res[0][1] = ((o1[0][0] * o2[0][1]) % DIV) + ((o1[0][1] * o2[1][1]) % DIV);
        res[1][0] = res[0][1];
        res[1][1] = ((o1[1][0] * o2[0][1]) % DIV) + ((o1[1][1] * o2[1][1]) % DIV);
        res[0][0] = (res[0][1] + res[1][1]) % DIV;
        return res;
    }
}