import java.io.*;

public class Problem_1484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());

        int i = (int) Math.ceil(Math.sqrt(g)), j = 1;
        double first, second;
        boolean wrote = false;

        while (i != j) {
            first = Math.pow(i, 2);
            second = Math.pow(j, 2);
            if (first - second == g) {
                bw.write(i + "\n");
                wrote = true;
                i += 1;
                j += 1;
            } else if (first - second > g) {
                j++;
            } else if (first - second < g) {
                i++;
            }
        }
        if (!wrote) {
            bw.write("-1");
        }
        bw.flush();
    }
}