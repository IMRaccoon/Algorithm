import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_6064 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCount = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCount; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(m > n) {
                int tmp = m;
                m = n;
                n = tmp;

                tmp = y;
                y = x;
                x = tmp;
            }

            int gcd = getGCD(Math.max(n, m), Math.min(n, m));
            int limit = (n / gcd) * (m / gcd) * gcd;

            if(x == y || x - y == n) {
                System.out.println(x);
            } else {
                int j = x;

                for (; j  <= limit; j += n) {
                    if((j - y) % m == 0) {
                        System.out.println(j);
                        break;
                    }
                }
                if(j > limit) {
                    System.out.println(-1);
                }
            }
        }
    }

    public static int getGCD(int a, int b) {
        if(b == 0) {
            return a;
        }
        return getGCD(b, a%b);
    }
}

