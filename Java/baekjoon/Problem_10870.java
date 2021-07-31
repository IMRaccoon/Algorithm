import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int [] pair = new int[]{0, 1};
        for(int i = 2; i <= N; i++) {
            pair[i % 2] += pair[(i + 1) % 2];
        }
        System.out.println(pair[N % 2]);
    }
}
