import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1676 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int two = 1, five = 0, tmp;
        if(n < 5) {
            System.out.println(0);
            return;
        }
        for(int i = 5; i <= n; i++) {
            tmp = i;
            while(tmp % 10 == 0) {
                tmp /= 10;
                two += 1;
                five += 1;
            }
            while(tmp % 2 == 0) {
                tmp /= 2;
                two += 1;
            }
            while(tmp % 5 == 0) {
                tmp /= 5;
                five += 1;
            }
        }
        System.out.println(Math.min(two, five));
    }
}
