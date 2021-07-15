import java.io.*;
import java.util.StringTokenizer;

public class Problem_12907 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int [] map = new int[41];
        long answer;
        int max = 0, tmp;

        for(int i = 0 ; i < n; i++) {
            tmp = Integer.parseInt(st.nextToken());
            max = Math.max(max, tmp);
            map[tmp] += 1;
        }

        boolean multiple = false;
        if(map[0] == 1) {
            answer = 1;
        } else if(map[0] == 2) {
            answer = 2;
            multiple = true;
        } else {
            System.out.println(0);
            return;
        }

        for(int i = 1; i <= max; i++) {
            if(multiple && map[i] == 2) {
                answer *= 2;
            } else if(map[i] == 1) {
                multiple = false;
            } else {
                System.out.println(0);
                return;
            }
        }
        if(multiple) {
            System.out.println(answer);
        } else {
            System.out.println(answer * 2);
        }
    }
}
