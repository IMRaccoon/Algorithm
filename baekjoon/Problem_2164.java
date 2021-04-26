import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem_2164 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= length; i++) {
            q.add(i);
        }

        int answer = 0;
        while(!q.isEmpty()) {
            answer = q.poll();
            if(!q.isEmpty()) {
                q.add(q.poll());
            }
        }
        System.out.println(answer);
    }
}
