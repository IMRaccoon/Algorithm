import java.io.*;
import java.util.StringTokenizer;

public class Problem_4781 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int candieTypeNum = Integer.parseInt(st.nextToken());
            int available = Math.round(Float.parseFloat(st.nextToken()) * 100);
            if (candieTypeNum == 0 && available == 0) {
                break;
            }

            Candie[] candies = new Candie[candieTypeNum];
            for (int i = 0; i < candieTypeNum; i++) {
                st = new StringTokenizer(br.readLine());
                candies[i] = new Candie(Integer.parseInt(st.nextToken()), Float.parseFloat(st.nextToken()));
            }

            int[] sum = new int[available + 1];

            for (int i = 0; i < candieTypeNum; i++) {
                int currentPrice = candies[i].price;
                int currentCalorie = candies[i].calorie;

                for (int j = currentPrice; j <= available; j++) {
                    sum[j] = Math.max(sum[j], currentCalorie + sum[j - currentPrice]);
                }
            }
            bw.write(sum[available] + "\n");
        }
        bw.flush();
    }

    static class Candie {
        int calorie;
        int price;

        Candie(int calorie, float price) {
            this.calorie = calorie;
            this.price = Math.round(price * 100);
        }
    }
}
