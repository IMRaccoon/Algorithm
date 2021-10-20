import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Work[] works = new Work[N];

        String[] input;
        for(int i = 0 ; i < N; i++) {
            input = br.readLine().split(" ");
            works[i] = new Work(i + Integer.parseInt(input[0]) - 1, Integer.parseInt(input[1]));
        }

        int [][] acc = new int[N][N];

        for(int i = 0 ; i < N; i++) {
            if (works[i].duration >= N) {
                if (i != 0) acc[i] = acc[i - 1];
                continue;
            }
            if (i == 0) {
                for (int j = works[i].duration; j < N; j++) {
                    acc[i][j] = works[i].price;
                }
            } else {
                for(int j = 0; j < works[i].duration; j++) acc[i][j] = acc[i - 1][j];
                acc[i][works[i].duration] = Math.max(acc[i - 1][i - 1] + works[i].price, acc[i - 1][works[i].duration]);
                for (int j = works[i].duration + 1; j < N; j++) {
                    acc[i][j] = Math.max(acc[i][j - 1], acc[i - 1][j]);
                }
            }
        }
        System.out.println(acc[N - 1][N - 1]);
    }

    private static class Work {
        int duration, price;

        Work(int duration, int price) {
            this.duration = duration;
            this.price = price;
        }
    }
}

