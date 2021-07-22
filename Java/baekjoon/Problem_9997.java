import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9997 {
    static int[] bits = new int[25];
    static int N;
    static int answer = 0;
    static int FULL = (int) Math.pow(2, 26) - 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (char a : br.readLine().toCharArray()) {
                bits[i] |= 1 << a - 'a';
            }
        }
        recursive(0, 0);
        System.out.println(answer);
    }

    private static void recursive(int index, int bit) {
        if(bit == FULL) {
            answer += (int) Math.pow(2, N - index);
            return;
        }
        if(index == N) return;

        recursive(index + 1, bit);
        recursive(index + 1, bit | bits[index]);
    }
}
