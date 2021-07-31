import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2747 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int [] saved = new int[]{0, 1};
        int N = Integer.parseInt(br.readLine());

        for(int i = 2; i <= N; i++) {
            saved[i % 2] += saved[(i + 1) % 2];
        }
        System.out.println(saved[N % 2]);
    }
}
