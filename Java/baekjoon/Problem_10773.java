import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        long sum = 0;
        int n = Integer.parseInt(br.readLine());
        int t;
        for (int i = 0; i < n; i++) {
            t = Integer.parseInt(br.readLine());
            if(t != 0) {
                stack.push(t);
                sum += t;
            } else {
                sum -= stack.pop();
            }
        }
        System.out.println(sum);
    }
}
