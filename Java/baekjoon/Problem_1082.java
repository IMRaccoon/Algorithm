import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1082 {
    static int[] prices;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        prices = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cheapest = 51;
        int cheapIndex = 0;
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
            if(i != 0) {
                if(cheapest >= prices[i]) {
                    cheapest = prices[i];
                    cheapIndex = i;
                }
            }
        }
        int money = Integer.parseInt(br.readLine());

        if(cheapest > money) {
            System.out.println(0);
            return;
        }
        ArrayList<Integer> pairIndex = new ArrayList<>();
        if (cheapest > prices[0]) {
            pairIndex.add(cheapIndex);
            money -= prices[cheapIndex];
            cheapest = prices[0];
            cheapIndex = 0;
        }
        for(int i = 0 ; i < Math.floorDiv(money, cheapest); i++) {
            pairIndex.add(cheapIndex);
        }
        money = Math.floorMod(money, cheapest);


        int numberOfArrayIndex = 0;
        int curIndex;
        while (money > 0 && numberOfArrayIndex != pairIndex.size()) {
            curIndex = pairIndex.get(numberOfArrayIndex);

            for(int i = N - 1; i > curIndex; i--) {
                if(money >= prices[i] - prices[curIndex]) {
                    money -= prices[i] - prices[curIndex];
                    pairIndex.set(numberOfArrayIndex, i);
                    break;
                }
            }

            numberOfArrayIndex += 1;
        }

        StringBuilder answer = new StringBuilder();
        for(int idx : pairIndex) {
            answer.append(idx);
        }
        System.out.println(answer.toString());
    }
}
