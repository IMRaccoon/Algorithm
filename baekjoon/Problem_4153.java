import java.io.*;
import java.util.StringTokenizer;

public class Problem_4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            double a = Math.pow(Integer.parseInt(st.nextToken()), 2);
            double b = Math.pow(Integer.parseInt(st.nextToken()), 2);
            double c = Math.pow(Integer.parseInt(st.nextToken()), 2);

            if(a == 0 && b == 0 && c == 0) {
                break;
            }
            if(a + b == c || a + c == b || b + c == a) {
                bw.write("right\n");
            } else {
                bw.write("wrong\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
