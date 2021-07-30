import java.io.*;
import java.util.StringTokenizer;

public class Problem_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int N = Integer.parseInt(br.readLine());
            int[][] sticker = new int[2][N + 1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    sticker[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            if (N != 1) {
                for (int i = 2; i <= N; i++) {
                    sticker[0][i] += Math.max(sticker[1][i - 2], sticker[1][i - 1]);
                    sticker[1][i] += Math.max(sticker[0][i - 2], sticker[0][i - 1]);
                }
            }
            bw.write(Math.max(sticker[0][N], sticker[1][N]) + "\n");
        }
        bw.flush();
    }
}
