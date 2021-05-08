import java.util.Scanner;

public class Problem_2231 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        int length = input.length();
        int origin = Integer.parseInt(input);


        int min = -1;
        for(int i = 1; i < (length * 9); i++) {
            if(origin == addAllElement(origin - i, length)) {
                min = origin - i;
            }
        }

        if(min == -1) {
            System.out.println(0);
        }
        else {
            System.out.println(min);
        }

    }

    public static int addAllElement(int target, int length) {
        int ret = 0;
        int origin = target;

        int div;
        for(int i = length - 1; i >= 0 ; i--) {
            div = (int) (target / Math.pow(10, i));
            ret += div;
            target -= (Math.pow(10, i) * div);
        }

        return ret + origin;
    }
}
