import java.io.*;
import java.util.StringTokenizer;

public class Problem_10830 {
    static int N;
    static int [][] origin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        origin = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int [][] answer = pow(origin, B);
        for(int i = 0; i < N; i++) {
            for(int j = 0 ; j < N; j++) {
                bw.write((answer[i][j] % 1000) + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }

    private static int[][] pow(int[][] matrix, long length) {
        if(length == 1) return matrix;
        int [][] res = pow(matrix, length / 2);
        res = multiple(res, res);

        if(length % 2 == 1) res = multiple(res, origin);
        return res;
    }

    private static int[][] multiple(int[][] o1, int[][] o2) {
        int[][] res = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    res[i][j] += (o1[i][k] * o2[k][j]) % 1000;
                }
            }
        }
        return res;
    }
}

