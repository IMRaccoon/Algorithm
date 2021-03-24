import java.util.Scanner;
import java.util.StringTokenizer;

public class Problem_2475 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());

        int result = 0;
        for(int i = 0 ; i < 5; i++) {
            int cur = Integer.parseInt(st.nextToken());
            result += (cur * cur);
        }
        System.out.println(result % 10);
    }
}
