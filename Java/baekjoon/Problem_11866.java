import java.util.LinkedList;
import java.util.Scanner;

public class Problem_11866 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder("<");
        int n = scan.nextInt(), k = scan.nextInt()-1;

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }

        int index = k;
        while (!list.isEmpty()) {
            sb.append(list.remove(index % list.size())).append(", ");
            if(!list.isEmpty()) {
                index = (index + k) % list.size();
            } else {
                index += k;
            }
        }
        System.out.println(sb.delete(sb.length() - 2, sb.length()).append(">"));
    }
}
