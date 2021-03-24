import java.util.Scanner;

public class Problem_1463 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int number = scan.nextInt();
        int[] map = new int[number + 1];

        for (int i = 1; i <= number; i++) {
            if (i + 1 <= number) map[i + 1] = map[i + 1] != 0 ? Math.min(map[i + 1], map[i] + 1) : map[i] + 1;
            if (i * 2 <= number) map[i * 2] = map[i * 2] != 0 ? Math.min(map[i * 2], map[i] + 1) : map[i] + 1;
            if (i * 3 <= number) map[i * 3] = map[i * 3] != 0 ? Math.min(map[i * 3], map[i] + 1) : map[i] + 1;
        }

        System.out.println(map[number]);
    }
}
