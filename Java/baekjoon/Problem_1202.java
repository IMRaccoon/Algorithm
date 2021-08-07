import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        PriorityQueue<Jewelry> jewelries = new PriorityQueue<>();
        LinkedList<Integer> bags = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken()), price = Integer.parseInt(st.nextToken());
            jewelries.add(new Jewelry(weight, price));
        }
        for (int i = 0; i < K; i++) bags.add(Integer.parseInt(br.readLine()));
        bags.sort(Comparator.naturalOrder());
        PriorityQueue<Integer> prices = new PriorityQueue<>(Comparator.reverseOrder());
        long answer = 0;
        for(int bag : bags) {
            while(!jewelries.isEmpty() && jewelries.peek().weight <= bag) {
                prices.add(jewelries.poll().price);
            }
            answer += prices.isEmpty() ? 0 : prices.poll();
        }
        System.out.println(answer);
    }

    private static class Jewelry implements Comparable<Jewelry> {
        int weight;
        int price;

        Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewelry jewelry) {
            return this.weight - jewelry.weight;
        }
    }
}
