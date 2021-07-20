import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_12904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder S = new StringBuilder(br.readLine()), T = new StringBuilder(br.readLine());

        boolean reverse = false;
        int s_size = S.length(), t_index;

        while(s_size != T.length()) {
            t_index = reverse ? 0 : T.length() - 1;
            if(T.charAt(t_index) == 'A') {
                T.deleteCharAt(t_index);
            } else {
                T.deleteCharAt(t_index);
                reverse = !reverse;
            }
        }

        if(reverse) {
            T.reverse();
        }
        if(S.toString().equals(T.toString())) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
