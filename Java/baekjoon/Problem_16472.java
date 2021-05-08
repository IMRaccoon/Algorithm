import java.util.Arrays;
import java.util.Scanner;

public class Problem_16472 {

    final static int alphaNum = 26;
    final static int init = 100001;
    static int [] alpha = new int[alphaNum];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int alphaCount = scan.nextInt();
        char[] arr = scan.next().toCharArray();
        Arrays.fill(alpha, init);

        int count = 0;
        int range = 0;
        int prevRange = 0;
        for (int i = 0; i < arr.length; i++) {
            int tmp = arr[i] - 'a';

            if (count < alphaCount) {
                if (alpha[tmp] == init) {
                    count++;
                }
                prevRange += 1;
            } else {
                if (alpha[tmp] != init) {
                    prevRange += 1;
                } else {
                    int min = findMinIndex();
                    prevRange = i - alpha[min];
                    alpha[min] = init;
                }
            }
            range = Math.max(range, prevRange);
            alpha[tmp] = i;
        }


        System.out.println(range);
    }

    public static int findMinIndex() {
        int minIndex = -1;
        int minTmp = init;
        for(int i = 0 ; i < alphaNum; i++) {
            if(minTmp > alpha[i]) {
                minIndex = i;
                minTmp = alpha[i];
            }
        }
        return minIndex;
    }
}
