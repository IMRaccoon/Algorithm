import java.io.*;
import java.util.StringTokenizer;

public class Problem_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());
        int bound = (int)Math.ceil(Math.sqrt(n));
        boolean [] map = new boolean[n + 1];

        for(int i = 2; i <= bound; i++) {
            if(map[i]) continue;
            int start = Math.floorDiv(m, i) * i;
            for(int j = start > i ? start : i * 2; j <= n; j += i) map[j] = true;
        }

        for(int i = m == 1 ? 2 : m; i <= n; i++) {
            if (!map[i]) sb.append(i).append("\n");
        }
        System.out.println(sb.toString());
    }
}
