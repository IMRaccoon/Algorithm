import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_17219 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();
        for(int i = 0 ; i < N; i++) {
            String[] input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }
        for(int i = 0 ; i < M; i++) {
            bw.write(map.get(br.readLine()));
            bw.newLine();
        }
        bw.flush();
    }
}
