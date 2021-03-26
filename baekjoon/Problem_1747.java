import java.util.Scanner;

public class Problem_1747 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int targetNumber = scan.nextInt();
        if(targetNumber == 1) {
            System.out.println(2);
        }
        else {
            while (!isPalindrome(targetNumber) || !isPrime(targetNumber)) {
                targetNumber++;
            }

            System.out.println(targetNumber);
        }
    }

    public static boolean isPrime(int num) {
        if(num == 2 || num == 3) {
            return true;
        }
        int square = (int)Math.ceil(Math.sqrt(num));


        for(int i = 2; i <= square; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int num) {
        StringBuilder tmp = new StringBuilder(String.valueOf(num));
        int length = tmp.length();
        int range = Math.floorDiv(length, 2);

        if(length == 1) {
            return true;
        }

        for (int i = 0; i < range; i++) {
            if (tmp.charAt(i) != tmp.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
