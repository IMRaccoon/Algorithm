import java.io.*;
import java.util.StringTokenizer;

public class Problem_10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());

            int floor = (customer - 1) % height + 1;
            int room = (customer - 1) / height + 1;
            if(room < 10) {
                bw.write(floor + "0" + room + "\n");
            } else {
                bw.write(floor + "" + room + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
