import java.util.Scanner;

public class Problem_12850 {
    static final int DIV = 1_000_000_007;
    static final int LENGTH = 8;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int D = scan.nextInt();
        
        long [][] matrix = new long[LENGTH][LENGTH];
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[1][0] = 1;
        matrix[1][2] = 1;
        matrix[1][3] = 1;
        matrix[2][0] = 1;
        matrix[2][1] = 1;
        matrix[2][3] = 1;
        matrix[2][4] = 1;
        matrix[3][1] = 1;
        matrix[3][2] = 1;
        matrix[3][4] = 1;
        matrix[3][5] = 1;
        matrix[4][2] = 1;
        matrix[4][3] = 1;
        matrix[4][5] = 1;
        matrix[4][6] = 1;
        matrix[5][3] = 1;
        matrix[5][4] = 1;
        matrix[5][7] = 1;
        matrix[6][4] = 1;
        matrix[6][7] = 1;
        matrix[7][5] = 1;
        matrix[7][6] = 1;

        matrix = pow(matrix, D);
        System.out.println(matrix[0][0]);
    }

    private static long[][] pow(long [][] c, long N) {
        if(N == 1) return c;
        long [][] res;
        if(N % 2 == 1) {
            res = multi(c, c);
            return multi(c, pow(res, N / 2));
        } else {
            res = multi(c, c);
            return pow(res, N / 2);
        }
    }

    private static long [][] multi(long [][] c1, long[][] c2) {
        long [][] res = new long[LENGTH][LENGTH];
        for(int i = 0 ; i < LENGTH; i++) {
            for(int j = 0; j < LENGTH; j++) {
                for(int k = 0; k < LENGTH; k++) {
                    res[i][j] = (res[i][j] + (c1[i][k] * c2[k][j])) % DIV;
                }
            }
        }
        return res;
    }
}

