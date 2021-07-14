import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int tmp = 0, sum = 0;
        boolean minus = false;
        for (char c : str.toCharArray()) {
            if (c == '+') {
                if (minus) {
                    sum -= tmp;
                } else {
                    sum += tmp;
                }
                tmp = 0;
            } else if (c == '-') {
                if (minus) {
                    sum -= tmp;
                } else {
                    sum += tmp;
                    minus = true;
                }
                tmp = 0;
            } else {
                tmp = (tmp * 10) + c - '0';
            }
        }
        if (minus) {
            System.out.println(sum - tmp);
        } else {
            System.out.println(sum + tmp);
        }
    }
}
