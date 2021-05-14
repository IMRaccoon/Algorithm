import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_11403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        Queue<Integer> q;

        int n = Integer.parseInt(br.readLine());
        int [][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            q = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) {
                    q.add(j);
                }
            }

            while (!q.isEmpty()) {
                int target = q.poll();
                map[i][target] = 1;
                for (int j = 0; j < n; j++) {
                    if (map[target][j] == 1 && map[i][j] != 1) {
                        q.add(j);
                    }
                }
            }
        }

        for(int i = 0 ; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }
        bw.flush();
    }
}
