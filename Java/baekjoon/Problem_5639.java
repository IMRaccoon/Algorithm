import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5639 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        Tree root = new Tree(Integer.parseInt(br.readLine()));
        String input;
        while (true) {
            input = br.readLine();
            if(input == null || input.length() == 0) break;
            root.insert(Integer.parseInt(input));
        }
        root.printAll();
        System.out.println(sb.toString());
    }

    private static class Tree {
        int num;
        Tree left, right;

        Tree(int num) {
            this.num = num;
        }

        void insert(int input) {
            if (num > input) {
                if (left == null) left = new Tree(input);
                else left.insert(input);
            } else {
                if (right == null) right = new Tree(input);
                else right.insert(input);
            }
        }

        void printAll() {
            if (left != null) {
                left.printAll();
            }
            if (right != null) {
                right.printAll();
            }
            sb.append(num).append("\n");
        }
    }
}
