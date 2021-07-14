import java.io.*;
import java.util.Stack;

public class Problem_4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String tmp;
        char[] chars;
        Stack<Character> stack;
        boolean isNo, isFinish;

        while (!(tmp = br.readLine()).equals(".")) {
            isNo = false;
            isFinish = false;
            stack = new Stack<>();
            chars = tmp.toCharArray();
            for (char c : chars) {
                switch (c) {
                    case '(':
                    case '[':
                        stack.push(c);
                        break;
                    case ')':
                        if (!stack.isEmpty() && (stack.peek() == '(')) {
                            stack.pop();
                        } else {
                            isNo = true;
                        }
                        break;
                    case ']':
                        if (!stack.isEmpty() && (stack.peek() == '[')) {
                            stack.pop();
                        } else {
                            isNo = true;
                        }
                        break;
                    case '.':
                        if (!stack.isEmpty()) {
                            isNo = true;
                        } else {
                            isFinish = true;
                        }
                        break;

                }

                if (isNo) {
                    bw.write("no\n");
                    break;
                }
                if (isFinish) {
                    bw.write("yes\n");
                    break;
                }
            }
        }
        bw.flush();
    }
}
