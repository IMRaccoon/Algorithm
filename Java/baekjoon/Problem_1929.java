import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        int bound = (int)Math.ceil(Math.sqrt(n));
        boolean [] map = new boolean[n + 1];
        if(m == 1) m = 2;

        for(int i = 2; i < bound; i++) {
            if(map[i]) continue;

            for(int j = i * 2; j <= n; j += i) {
                map[j] = true;
            }
        }

        for(int i = m; i <= n; i++) {
            if (!map[i]) System.out.println(i);
        }
    }
}
