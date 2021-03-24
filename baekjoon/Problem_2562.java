import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = -1;

        for(int i = 0 ; i < 9; i++) {
            int tmp = Integer.parseInt(br.readLine());
            if(tmp > max) {
                max = tmp;
                index = i;
            }
        }

        System.out.println(max);
        System.out.println(index + 1);
    }
}
