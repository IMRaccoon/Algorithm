import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_13172 {
    final static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());

        long ans = 0;
        for(int i = 0 ; i < M; i++) {
            String [] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]), S = Integer.parseInt(inputs[1]);
            int g = gcd(N, S);
            N /= g;
            S /= g;
            ans += S * multiply(N, MOD - 2) % MOD;
            ans %= MOD;
        }
        System.out.println(ans);
    }

    private static long multiply(int n, int mod) {
        if(mod == 1) return n;
        if(mod % 2 == 1) return n * multiply(n, mod - 1) % MOD;
        long t = multiply(n, mod / 2);
        return t * t % MOD;
    }

    private static int gcd(int n, int m) {
        if(m == 0) return n;
        return gcd(m, n % m);
    }
}

