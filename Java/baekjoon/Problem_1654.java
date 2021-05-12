import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken()), n = Integer.parseInt(st.nextToken());

        int [] map = new int[k];
        long max = 0, min = 1, mid;

        for(int i = 0 ; i < k; i++) {
            map[i] = Integer.parseInt(br.readLine());
            max = Math.max(map[i], max);
        }

        int count;
        long result = 0;
        while(min <= max) {
            mid = Math.floorDiv((max + min), 2);
            count = 0;

            for (int i = 0; i < k; i++) {
                count += Math.floorDiv(map[i], mid);
            }

            if (count >= n) {
                result = mid;
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }

        System.out.println(result);
    }
}
