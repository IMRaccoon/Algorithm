import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1007 {
    static int N;
    static int[][] pair;
    static double sumX, sumY;
    static double answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            answer = Double.MAX_VALUE;
            pair = new int[N][2];
            sumX = 0;
            sumY = 0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                pair[i][0] = Integer.parseInt(st.nextToken());
                pair[i][1] = Integer.parseInt(st.nextToken());
                sumX += pair[i][0];
                sumY += pair[i][1];
            }

            recursive(0, 0, 0, 0);
            System.out.printf("%.6f\n", answer);
        }
    }

    private static void recursive(int count, int start, long halfX, long halfY) {
        if (count == (N / 2)) {
            double finalX = (halfX * 2) - sumX;
            double finalY = (halfY * 2) - sumY;
            answer = Math.min(answer, Math.sqrt((finalX * finalX) + (finalY * finalY)));
        } else {
            for (int i = start; i < N; i++) {
                recursive(count + 1, i + 1, halfX + pair[i][0], halfY + pair[i][1]);
            }
        }
    }
}

