import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1629 {
    static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);

        System.out.println(divide(B) % C);
    }

    private static long divide(int b) {
        if (b == 1) return A % C;
        long res = divide(b / 2) % C;
        if (b % 2 == 1) {
            return ((res * res) % C) * (A % C);
        }
        return (res * res) % C;
    }
}
