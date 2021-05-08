import java.io.*;

public class Problem_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder(br.readLine());
        while(!sb.toString().equals("0")) {
            int length = sb.length() - 1;
            boolean flag = true;


            for(int i = 0 ; i <= (length / 2); i++) {
                if(sb.charAt(i) != sb.charAt(length - i)) {
                    bw.write("no\n");
                    flag =false;
                    break;
                }
            }
            if(flag) {
                bw.write("yes\n");
            }
            sb = new StringBuilder(br.readLine());
        }
        bw.flush();

    }
}
