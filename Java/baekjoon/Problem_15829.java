import java.util.Scanner;

public class Problem_15829 {
    private final static int M = 1234567891;
    private final static int R = 31;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();
        char [] arr = scan.next().toCharArray();

        double result = 0;
        long multiple = 1;
        for(int i = 0 ; i < length; i++) {
            result += ((arr[i] - 'a' + 1) * multiple) % M;
            multiple = (R * multiple) % M;
        }
        System.out.println((int)(result % M));
    }
}

