import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_9375 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            int N = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                String spices = st.nextToken();

                if (map.containsKey(spices)) {
                    map.replace(spices, map.get(spices) + 1);
                } else {
                    map.put(spices, 1);
                }
            }

            long sum = 0, answer = 0;
            for(int count : map.values()) {
                answer += (answer * count);
                answer += count;
                sum += count;
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}