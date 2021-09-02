import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1562 {
    private final static int DIV = 1_000_000_000;
    private static int[] bits;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][][] acc = new int[N][10][1024];
        bits = new int[10];
        for (int i = 0; i < 10; i++) {
            bits[i] = (int) Math.pow(2, i);
        }
        for (int i = 1; i <= 9; i++) {
            acc[0][i][bits[i]] = 1;
        }

        for (int i = 0; i < N - 1; i++) {
            for (int cur = 0; cur < 10; cur++) {
                for (int j = 1; j < 1024; j++) {
                    if (acc[i][cur][j] == 0) continue;
                    if(cur != 9) acc[i + 1][cur + 1][checkDigit(j, cur + 1)] += acc[i][cur][j] % DIV;
                    if(cur != 0) acc[i + 1][cur - 1][checkDigit(j, cur - 1)] += acc[i][cur][j] % DIV;
                }
            }
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) sum += acc[N - 1][i][1023];
        System.out.println(sum % DIV);
    }

    private static int checkDigit(int curVal, int nextDigit) {
        if ((curVal >> nextDigit) % 2 == 1) return curVal;
        return curVal + bits[nextDigit];
    }
}