import java.util.Scanner;

public class Problem_9663 {
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();

        if (n == 1) {
            System.out.println(1);
        } else {
            int counter = table(new int[n], 0);
            System.out.println(counter);
        }
    }
    public static int table(int[] arr, int index) {
        if(index == n) {
            return 1;
        }
        int counter = 0;
        for(int i = 0 ; i < n; i++) {
            if(canSave(arr, index, i)) {
                // i 번째 자리에 저장
                arr[index] = i;
                counter += table(arr, index+1);
            }
        }
        return counter;
    }

    public static boolean canSave(int[] arr, int index, int pos) {
        // index 번째, pos 자리
        for(int i = 0 ; i < index; i++) {
            if(arr[i] == pos) {
                return false;
            }
            else if(Math.abs(index - i) == Math.abs(pos - arr[i])) {
                return false;
            }
        }
        return true;
    }

}
