import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_2550 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int [] left = new int[N + 1];
        int [] right = new int[N + 1];
        int [] dp = new int[N + 1];


        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            right[Integer.parseInt(st.nextToken())] = i;
        }

        int max = 0;
        for (int i = 1; i <= N; i++) {
            int cur = left[i];
            dp[i] = 1;
            for (int j = i; j >= 1; j--) {
                if (right[cur] > right[left[j]] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }

        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = N; i >= 1; i--) {
            if(max == dp[i]) {
                max -= 1;
                answer.add(left[i]);
            }
        }
        answer.sort(Comparator.naturalOrder());
        bw.write(answer.size() + "\n");
        for(int a : answer) {
            bw.write(a + " ");
        }
        bw.flush();
    }
}