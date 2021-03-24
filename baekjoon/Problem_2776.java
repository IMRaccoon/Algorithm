import java.io.*;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Problem_2776 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++) {
            int recordLength = Integer.parseInt(br.readLine());
            TreeSet<Integer> recorded = new TreeSet<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < recordLength; j++) {
                recorded.add(Integer.parseInt(st.nextToken()));
            }

            int checkLength = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ;  j< checkLength; j++) {
                if(recorded.contains(Integer.parseInt(st.nextToken()))) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            }
            bw.flush();
        }
    }
}
