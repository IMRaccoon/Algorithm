import java.io.*;

public class Problem_15652 {
    static int N, M;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M];
        recursive(0, 1);
        System.out.print(sb.toString());
    }

    private static void recursive(int pos, int cur) {
        if(pos == M) {
            for(int a : arr) sb.append(a).append(" ");
            sb.append("\n");
        } else {
            for (int i = cur; i <= N; i++) {
                arr[pos] = i;
                recursive(pos + 1, i);
            }
        }
    }
}
