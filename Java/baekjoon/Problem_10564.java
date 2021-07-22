import java.io.*;
import java.util.*;

public class Problem_10564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] scores = new int[M];
            boolean[][] visited = new boolean[N + 1][N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }
            int answer = -1;
            visited[0][0] = true;

            for(int i = 0 ; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    if (!visited[i][j]) continue;
                    for (int k = 0; k < M; k++) {
                        if (i + j + scores[k] > N) continue;
                        else if (i + j + scores[k] == N) {
                            answer = Math.max(j + scores[k], answer);
                        }
                        visited[i + j + scores[k]][j + scores[k]] = true;
                    }
                }
            }
            bw.write(String.valueOf(answer));
            bw.newLine();
        }
        bw.flush();
    }
}