import java.util.Scanner;

public class Problem_17626 {
    static int[] map;
    static int[] visited;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int index = (int) Math.sqrt(N);
        map = new int[index + 1];
        visited = new int[index + 1];
        for (int i = 1; i <= index; i++) {
            map[i] = (int) Math.pow(i, 2);
        }

        int answer = recursive(N, index, 0);
        System.out.println(answer);
    }

    private static int recursive(int N, int index, int count) {
        if (count >= 5 || index == 0) return Integer.MAX_VALUE;
        if ((N / map[index]) + count > 4) return Integer.MAX_VALUE;
        if (N == 0) return count;

        int nextN = N % map[index];

        if (nextN > 0) {
            return Math.min(recursive(nextN, (int) Math.sqrt(nextN), count + (N / map[index])), recursive(N, index - 1, count));
        } else {
            return count + (N / map[index]);
        }
    }
}