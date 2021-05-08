import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14391 {
    static int [][] paper;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        paper = new int[n][m];

        for(int i = 0 ; i < n ; i ++) {
             String line = br.readLine();
             for(int j = 0 ; j < m; j++) {
                 paper[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
             }
        }


        System.out.println(recursive(new Pair(0, 0), new Pair(m - 1, n - 1)));

    }


    public static int recursive(Pair start, Pair end) {

        if(start.x == end.x || start.y == end.y) {
            return calculateValue(start, end);
        }

        else {
            int first = calculateValue(new Pair(start.x, start.y), new Pair(end.x, start.y)) + recursive(new Pair(start.x, start.y + 1), new Pair(end.x, end.y));
            int second = calculateValue(new Pair(end.x, start.y), new Pair(end.x, end.y)) + recursive(new Pair(start.x, start.y), new Pair(end.x - 1, end.y));
            int third = calculateValue(new Pair(start.x, start.y), new Pair(start.x, end.y)) + recursive(new Pair(start.x + 1, start.y), new Pair(end.x, end.y));
            int fourth = calculateValue(new Pair(start.x, end.y), new Pair(end.x, end.y)) + recursive(new Pair(start.x, start.y), new Pair(end.x, end.y - 1));


            int compareA = Math.max(first, second);
            int compareB = Math.max(third, fourth);

            return Math.max(compareA, compareB);
        }
    }

    public static int calculateValue(Pair start, Pair end) {
        int sum = 0;
        if(start.x == end.x) {
            int x = start.x;
            for(int i = start.y; i <= end.y; i++) {
                sum += (paper[i][x] * Math.pow(10, (end.y - i)));
            }
            return sum;
        } else {
            int y = start.y;
            for (int i = start.x; i <= end.x; i++) {
                sum += (paper[y][i] * Math.pow(10, (end.x - i)));
            }
            return sum;
        }
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
