import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int length = Integer.parseInt(st.nextToken()), limit = Integer.parseInt(st.nextToken());

        int [] cards = new int[length];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        int max = -1;
        for(int i = 0 ; i < length; i++) {
            for(int j = i + 1; j < length; j++) {
                for(int k = j + 1; k < length; k++) {
                    if(cards[i] + cards[j] + cards[k] <= limit) {
                        max = Math.max(max, cards[i] + cards[j] + cards[k]);
                    } else {
                        break;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
