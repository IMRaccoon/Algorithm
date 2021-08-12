import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1786 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int count = 0;

        char[] T = br.readLine().toCharArray();
        char[] P = br.readLine().toCharArray();
        int[] pArray = getIntArr(P);
        int limit = pArray.length, length = T.length;
        if (length < limit) {
            System.out.println(0);
            return;
        }

        int j = 0;
        for (int i = 0; i < length; i++) {
            while (j > 0 && P[j] != T[i]) j = pArray[j - 1];
            if (P[j] == T[i]) {
                if (j == limit - 1) {
                    answer.append(i - j + 1).append(" ");
                    j = pArray[j];
                    count += 1;
                } else j += 1;
            }
        }

        System.out.println(count);
        System.out.println(answer);
    }

    private static int[] getIntArr(char[] target) {
        int size = target.length;
        int[] arr = new int[size];

        int tmp = 0;
        for(int i = 1; i < size; i++) {
            while(tmp > 0 && target[i] != target[tmp]) tmp = arr[tmp - 1];
            if(target[i] == target[tmp]) {
                tmp += 1;
                arr[i] = tmp;
            }
        }
        return arr;
    }
}
