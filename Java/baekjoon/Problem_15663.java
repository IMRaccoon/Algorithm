import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_15663 {
    private static int n, m;
    private static boolean [] check;
    private static int [] array, result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        result = new int[m];
        check = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        recursive(0);
    }

    private static void recursive(int count) {
        if(count == m) {
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < m; i++) {
                sb.append(result[i] + " ");
            }
            System.out.println(sb);
            return;
        }

        int before = 0;
        for(int i = 0; i< n; i++) {
            if (!check[i] && before != array[i]) {
                check[i] = true;
                result[count] = array[i];
                before = array[i];
                recursive(count + 1);
                check[i] = false;
            }
        }
    }
}
