import java.io.*;

public class Problem_11726 {
    final static int DIV = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n + 1];
        if(n == 1 || n == 2) {
            bw.write(String.valueOf(n));
            bw.flush();
            return;
        }

        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i - 1] % DIV) + (arr[i - 2] % DIV);
        }
        bw.write(String.valueOf(arr[n] % DIV));
        bw.flush();
    }
}
