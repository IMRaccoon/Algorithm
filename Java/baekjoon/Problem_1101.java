import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1101 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] sticker = new int[N];
        int[] spices = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if(!st.nextToken().equals("0")) {
                    spices[i] += 1;
                    sticker[i] = j;
                }
            }
        }
        if (N == 1) {
            System.out.println(0);
            return;
        }

        boolean[] fixed = new boolean[M];
        int answer = 0;
        for (int i = 0; i < N; i++) {
            if (spices[i] == 1) {
                if(fixed[sticker[i]]) answer += 1;
                else fixed[sticker[i]] = true;
            } else if (spices[i] > 1) {
                answer += 1;
            }
        }
        System.out.println(answer > 0 ? answer - 1 : answer);
    }
}
