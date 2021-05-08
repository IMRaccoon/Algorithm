import java.util.Scanner;

public class Problem_2775 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();

        for (int i = 0; i < t; i++) {
            int floor = scan.nextInt(), room = scan.nextInt();
            int[][] people = new int[floor + 1][room];

            for (int j = 0; j < room; j++) {
                people[0][j] = j + 1;
            }
            for (int j = 1; j <= floor; j++) {
                people[j][0] = 1;
                for (int k = 1; k < room; k++) {
                    people[j][k] = people[j - 1][k] + people[j][k - 1];
                }
            }
            System.out.println(people[floor][room - 1]);
        }
    }
}