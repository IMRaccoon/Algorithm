// 1 Score
package level_1;

import java.util.Scanner;

public class Solve_30 {
    public static void main(String[] args) {
        Solve_30 sol = new Solve_30();
    }
    private Solve_30() {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        for(int i = 0; i<b; i++) {
            for(int j = 0; j<a; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
