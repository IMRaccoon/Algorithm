import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int count = 0;

        for(int i = 0 ; i <n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(cur == 1) {
                continue;
            }

            boolean check = false;
            for(int j = 2; j <= Math.sqrt(cur); j++) {
                if(cur % j == 0) {
                    check = true;
                    break;
                }
            }
            if(!check) count ++;

        }
        System.out.println(count);
    }
}
