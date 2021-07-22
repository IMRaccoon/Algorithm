import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5525 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean isI = true;
        int counter = 0;
        int answer = 0;

        for (char c : br.readLine().toCharArray()) {
            if (isI && c == 'I') {
                counter += 1;
                isI = false;
            } else if (!isI && c == 'O') {
                isI = true;
            } else {
                if (counter >= (N + 1)) {
                    answer += counter - N;
                }
                counter = c == 'I' ? 1 : 0;
            }
        }
        if (counter >= (N + 1)) {
            answer += counter - N;
        }

        System.out.println(answer);
    }
}
