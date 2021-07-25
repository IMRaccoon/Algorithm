import java.io.*;
import java.util.StringTokenizer;

public class Problem_11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int arr = 0;
        int[] sum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr += Integer.parseInt(st.nextToken());
            sum[i] = arr;
        }

        while (M-- != 0) {
            st = new StringTokenizer(br.readLine());
            int I = Integer.parseInt(st.nextToken()), J = Integer.parseInt(st.nextToken());
            bw.write(sum[J] - sum[I - 1] + "\n");
        }
        bw.flush();
    }
}
