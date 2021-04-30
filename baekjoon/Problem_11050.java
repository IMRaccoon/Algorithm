import java.util.Scanner;

public class Problem_11050 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();

        if(n - k < k) {
            k = n - k;
        }

        int top = 1;
        int bottom = 1;
        for(int i = 0 ; i < k; i++) {
            top *= (n - i);
            bottom *= (k - i);
        }

        System.out.println(top / bottom);
    }
}
