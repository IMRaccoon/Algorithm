import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_18234 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());

        long answer = 0;
        int[][] carrots = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            carrots[i][0] = Integer.parseInt(st.nextToken());
            carrots[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(carrots, Comparator.comparingInt(t -> t[1]));
        int sub = T - N;
        for (int i = 0; i < N; i++) {
            answer += (carrots[i][0] + ((long) (sub + i) * carrots[i][1]));
        }
        System.out.println(answer);
    }
}
