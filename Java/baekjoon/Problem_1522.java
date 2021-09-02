import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1522 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int originB = 0;
        for (char a : arr) {
            if (a == 'b') originB += 1;
        }

        int curB = 0;
        for (int i = 0; i < originB; i++) {
            if (arr[i] == 'b') curB += 1;
        }
        int answer = originB - curB;

        for (int start = 0; start < arr.length; start++) {
            if (arr[start] == 'b') curB -= 1;
            if (arr[(start + originB) % arr.length] == 'b') curB += 1;
            answer = Math.min(answer, originB - curB);
        }
        System.out.println(answer);
    }
}

