import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_15657 {
    static int N, M;
    static int[] arr;
    static int[] ans;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        recursive(0, 0);
        System.out.print(sb.toString());
    }

    private static void recursive(int pos, int cur) {
        if(pos == M) {
            for(int a : ans) sb.append(a).append(" ");
            sb.append("\n");
        } else {
            for (int i = cur; i < N; i++) {
                ans[pos] = arr[i];
                recursive(pos + 1, i);
            }
        }
    }
}
