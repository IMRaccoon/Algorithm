import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Problem_1246 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int eggNumber = Integer.parseInt(st.nextToken());
        int personNumber = Integer.parseInt(st.nextToken());

        ArrayList<Integer> purchasePrice = new ArrayList<>(personNumber);

        for(int i = 0 ; i < personNumber; i++) {
            purchasePrice.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(purchasePrice);
        if(eggNumber < personNumber) {
            purchasePrice = new ArrayList(purchasePrice.subList(personNumber - eggNumber, purchasePrice.size()));
        } else if(eggNumber > personNumber) {
            eggNumber = personNumber;
        }

        int maxPrice = 0;
        int totalPrice = 0;
        for(int price : purchasePrice) {
            int currentEgg = eggNumber--;
            int currentTotal = price * currentEgg;

            if(totalPrice < currentTotal) {
                totalPrice = currentTotal;
                maxPrice = price;
            }
        }

        System.out.println(maxPrice + " " + totalPrice);
    }
}
