import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        char[] boom = br.readLine().toCharArray();

        int length = input.length;
        int boomLength = boom.length;

        Stack<Character> stack = new Stack<>();
        Stack<Character> tmp = new Stack<>();
        for (int i = 0; i < length; i++) {
            stack.push(input[i]);
            if (stack.size() >= boomLength && input[i] == boom[boomLength - 1]) {
                boolean isSame = true;
                for (int j = 1; j <= boomLength; j++) {
                    if (tmp.push(stack.pop()) != boom[boomLength - j]) {
                        isSame = false;
                    }
                }
                if (isSame) tmp.clear();
                else {
                    while (!tmp.isEmpty()) {
                        stack.push(tmp.pop());
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stack) {
            sb.append(ch);
        }
        System.out.println(sb.length() > 0 ? sb.toString() : "FRULA");
    }
}
