import java.io.*;

public class Problem_1013 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            bw.write(br.readLine().matches("(100+1+|01)+") ? "YES\n" : "NO\n");
        }
        bw.flush();
    }
}