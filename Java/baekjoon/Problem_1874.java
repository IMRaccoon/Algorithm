import java.io.*;
import java.util.Stack;

public class Problem_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        s.push(0);
        int target, start = 1;

        for(int i = 0 ; i < n; i++) {
            target = Integer.parseInt(br.readLine());
            if (start < target) {
                for (int j = start; j < target; j++) {
                    s.push(j);
                    sb.append("+\n");
                }
                sb.append("+\n-\n");
                start = target + 1;
            } else if (start == target) {
                sb.append("+\n-\n");
                start = target + 1;
            } else {
                if (s.peek() == target) {
                    s.pop();
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }

            }
        }
        System.out.println(sb);
    }
}
