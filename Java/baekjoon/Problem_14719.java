import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int H = Integer.parseInt(input[0]);
        int W = Integer.parseInt(input[1]);

        int[] blocks = new int[W];
        input = br.readLine().split(" ");
        for (int i = 0; i < W; i++) {
            blocks[i] = Integer.parseInt(input[i]);
        }

        int answer = 0;

        for (int h = H; h >= 0; h--) {
            int index = -1;
            for (int i = 0; i < W; i++) {
                if (blocks[i] > h) {
                    if (index != -1) answer += (i - index - 1);
                    index = i;
                }
            }
        }
        System.out.println(answer);
    }
}