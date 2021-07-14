import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
        int size, index, answer = 0;

        for (int i = n - 1; i >= 0; i--) {
            size = (int) Math.pow(Math.pow(2, i), 2);
            index = (int) Math.sqrt(size);

            if(Math.floorDiv(r, index) == 1) {
                r %= index;
                answer += (size * 2);
            }
            if(Math.floorDiv(c, index) == 1) {
                c %= index;
                answer += size;
            }
        }

        System.out.println(answer);
    }
}
