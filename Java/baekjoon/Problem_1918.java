import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        StringBuilder sb = new StringBuilder("");

        Stack<Character> stack = new Stack<>();
        for (char c : input) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (stack.peek() != '(') sb.append(stack.pop());
                stack.pop();
            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                int check = operationCheck(c);
                while (!stack.isEmpty() && operationCheck(stack.peek()) >= check) {
                    sb.append(stack.pop());
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb.toString());
    }

    private static int operationCheck(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        } else {
            return 0;
        }
    }
}
