import java.util.Scanner;

public class Problem_2748 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();

        long [] saved = new long[]{0, 1};
        for(int i = 2; i <= N; i++) {
            saved[i % 2] += saved[(i + 1) % 2];
        }
        System.out.println(saved[N % 2]);
    }
}
