import java.util.Scanner;

public class Problem_1436 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if(n == 1) {
            System.out.println(666);
            return;
        }

        int i = 665;
        while(n != 0) {
            if(String.valueOf(++i).contains("666")) {
                n -= 1;
            }
        }
        System.out.println(i);
    }
}

