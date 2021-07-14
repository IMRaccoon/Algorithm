import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String[] arr = new String[n];
        String input;
        int index;

        for (int i = 0; i < n; i++) {
            input = br.readLine();
            map.put(input, i);
            arr[i] = input;
        }


        for (int i = 0; i < m; i++) {
            input = br.readLine();
            if(input.charAt(0) >= 'A' && input.charAt(0) <= 'Z') {
                bw.write(map.get(input) + 1 + "\n");
            } else {
                index = Integer.parseInt(input);
                bw.write(arr[index - 1] + "\n");
            }
        }
        bw.flush();
    }
}
