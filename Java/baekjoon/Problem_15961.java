import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken());

        int[] dishes = new int[N];
        int[] spices = new int[D + 1];

        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        int curTotal = 0;
        for (int i = 0; i < K; i++) {
            if (spices[dishes[i]] == 0) curTotal += 1;
            spices[dishes[i]] += 1;
        }
        int answer = spices[C] == 0 ? curTotal + 1 : curTotal;
        for (int start = K; start < N + K; start++) {
            spices[dishes[start - K]] -= 1;
            if (spices[dishes[start - K]] == 0) curTotal -= 1;
            if (spices[dishes[start % N]] == 0) curTotal += 1;
            spices[dishes[start % N]] += 1;

            answer = Math.max(answer, spices[C] == 0 ? curTotal + 1 : curTotal);
        }
        System.out.println(answer);
    }
}
