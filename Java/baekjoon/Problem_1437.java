import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N <= 3) {
            System.out.println(N);
        } else {
            int res = 1;
            while(N % 3 != 0) {
                N -= 2;
                res = (res * 2) % 10007;
            }
            for(int i = 0; i < (N / 3); i++) {
                res = (res * 3) % 10007;
            }
            System.out.println(res);
        }
    }
}