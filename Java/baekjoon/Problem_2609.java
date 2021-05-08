import java.util.Scanner;

public class Problem_2609 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();

        int max = a > b ? gcd(a, b) : gcd(b, a);
        System.out.println(max);
        int min = a * b / max;
        System.out.println(min);
    }

    static int gcd (int a, int b) {
        if(a % b == 0) return b;
        return gcd(b, a % b);
    }
}
