import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int [] map = new int[20000001];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i ++){
            map[Integer.parseInt(st.nextToken()) + 10000000] ++;
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < m; i++) {
            sb.append(map[Integer.parseInt(st.nextToken()) + 10000000]).append(" ");
        }
        System.out.println(sb);
    }
}
