import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp_asc = new int[N];
        int[] dp_desc = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            dp_asc[i] = 1;
            for (int j = i; j >= 0; j--) {
                if (arr[i] > arr[j] && dp_asc[i] < dp_asc[j] + 1) {
                    dp_asc[i] = dp_asc[j] + 1;
                }
            }
        }
        for(int i = N- 1; i >= 0; i--) {
            dp_desc[i] = 1;
            for (int j = i; j < N; j++) {
                if (arr[i] > arr[j] && dp_desc[i] < dp_desc[j] + 1) {
                    dp_desc[i] = dp_desc[j] + 1;
                }
            }
        }
        int answer = 0;
        for(int i = 0 ; i < N; i++) {
            answer = Math.max(dp_asc[i] + dp_desc[i] - 1, answer);
        }
        System.out.println(answer);
    }
}
