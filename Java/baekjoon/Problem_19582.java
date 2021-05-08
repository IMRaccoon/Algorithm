import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_19582 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        boolean canRemove = true;
        int maxPrice = 0;
        long sum = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int limit = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            if (limit < sum) {
                if (canRemove) {
                    if (price < maxPrice && sum - maxPrice <= limit) {
                        sum -= maxPrice;
                        sum += price;
                    }
                    canRemove = false;
                } else {
                    System.out.println("Zzz");
                    return;
                }
            } else {
                maxPrice = Math.max(maxPrice, price);
                sum += price;
            }
        }
        System.out.println("Kkeo-eok");
    }
}
