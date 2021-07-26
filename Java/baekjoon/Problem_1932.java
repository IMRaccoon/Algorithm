import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] acc = new int[N];
        int[] cur = new int[N];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i; j++) {
                cur[j] = Integer.parseInt(st.nextToken());
            }
            cur[0] += acc[0];
            for (int j = 1; j < i; j++) {
                cur[j] += Math.max(acc[j - 1], acc[j]);
            }
            acc = Arrays.copyOf(cur, N);
        }
        int max = 0;
        for(int a : acc) {
            max = Math.max(a, max);
        }
        System.out.println(max);
    }
}
