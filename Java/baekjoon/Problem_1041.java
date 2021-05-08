import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1041 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        long n = Integer.parseInt(br.readLine());

        int [] dice = new int[6];
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        int a = Math.min(dice[0], dice[5]);
        int b = Math.min(dice[1], dice[2]);
        int c = Math.min(dice[2], dice[3]);

        long firstDimension = Math.min(a, Math.min(b, c));
        long secondDimension = Math.min(a + b, Math.min(b + c, c + a));
        long thirdDimension = a + b + c;

        if(n == 1) {
            int max = Integer.MIN_VALUE;
            int sum = 0;
            for(int i = 0 ; i < 6; i++) {
                sum += dice[i];
                max = Math.max(max, dice[i]);
            }
            System.out.println(sum - max);
        }
        else {
            long answer = 4 * thirdDimension;
            answer += (4 * (n - 1) + 4 * (n - 2)) * secondDimension;
            answer += (4 * (n - 1) * (n - 2) + (n - 2) * (n - 2)) * firstDimension;
            System.out.println(answer);
        }
    }
}
