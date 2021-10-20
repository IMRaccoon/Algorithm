import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int [] arr = new int[N];
        String [] input = br.readLine().split(" ");
        for(int i = 0 ; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        int B = Integer.parseInt(input[0]), C = Integer.parseInt(input[1]);

        long answer = 0;
        for(int a : arr) {
            answer += (int)Math.ceil((double)Math.max(a - B, 0) / (double)C) + 1;
        }
        System.out.println(answer);
    }
}
