import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15979 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Math.abs(Integer.parseInt(st.nextToken()));
        int m = Math.abs(Integer.parseInt(st.nextToken()));

        if(n == 0 || m == 0) {
            if(n == 0 && m == 0) {
                System.out.println(0);
            } else if(n == 1 || m == 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        } else {
            System.out.println(Math.min(2, gcd(n, m)));
        }
    }

    static int gcd(int a, int b) {
        if(a%b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
