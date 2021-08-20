import java.io.*;
import java.util.StringTokenizer;

public class Problem_11309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        long[][] map = new long[33][33];

        for (int egg = 1; egg <= 32; egg++) {
            for (int drop = 1; drop <= 32; drop++) {
                map[egg][drop] = map[egg][drop - 1] + map[egg - 1][drop - 1] + 1;
            }
        }

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int floor = Integer.parseInt(st.nextToken());
            int egg = Integer.parseInt(st.nextToken());

            int res;
            for (res = 1; res <= 32; res++) {
                if (map[egg][res] >= floor) {
                    break;
                }
            }
            if (res == 33) bw.write("Impossible\n");
            else bw.write(res + "\n");
        }
        bw.flush();
    }
}
