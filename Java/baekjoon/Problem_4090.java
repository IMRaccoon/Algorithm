import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_4090 {
    static int[] list, clone;
    static int[] pow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pow = new int[7];
        clone = new int[10];
        for(int i = 0; i <= 6; i++) pow[i] = (int)Math.pow(10, i);
        int input;
        while ((input = Integer.parseInt(br.readLine())) > 0) {
            while (true) {
                addList(input);
                if (primeFactorization(input)) break;
                input++;
            }
            System.out.println(input);
        }
    }

    private static void addList(int input) {
        int length = String.valueOf(input).length();
        list = new int[10];
        for (int i = length - 1; i >= 0; i--) {
            list[input / pow[i]] += 1;
            input %= pow[i];
        }
    }


    private static boolean primeFactorization(int input) {
        int limit = (int) Math.ceil(Math.sqrt(input));
        for (int i = 2; i <= limit; i++) {
            if (input % i == 0) {
                System.arraycopy(list, 0, clone, 0, 10);
                if (checkCharacter(clone, i) && checkCharacter(clone, (input / i))) return true;
            }
        }
        return false;
    }

    private static boolean checkCharacter(int [] clone, int A) {
        int length, cur;
        length = String.valueOf(A).length() - 1;
        for (int i = length; i >= 0; i--) {
            cur = A / pow[i];
            if (clone[cur]-- > 0) {
                A %= pow[i];
            } else {
                return false;
            }
        }
        return true;
    }
}
