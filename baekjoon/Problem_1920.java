import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Problem_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int recordLength = Integer.parseInt(br.readLine());
        int [] recorded = new int[recordLength];
        st = new StringTokenizer(br.readLine());
        for(int j = 0 ; j < recordLength; j++) {
            recorded[j] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(recorded);

        int checkLength = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());


        for(int j = 0 ;  j< checkLength; j++) {
            if(Arrays.binarySearch(recorded, Integer.parseInt(st.nextToken())) >= 0) {
                bw.write(1+ "\n");
            } else {
                bw.write(0 + "\n");
            }
        }
        bw.flush();
    }
}
