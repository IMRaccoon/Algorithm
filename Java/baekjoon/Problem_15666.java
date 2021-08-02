import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_15666 {
    static int N, M;
    static Integer[] arr;
    static int[] ans;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = set.stream().sorted().toArray(Integer[]::new);
        N = arr.length;


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
