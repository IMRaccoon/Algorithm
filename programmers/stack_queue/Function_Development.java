// 3 Score
package stack_queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Function_Development {
    public static void main(String[] args) {
        Function_Development FD = new Function_Development();
    }
    private Function_Development() {
        System.out.println(Arrays.toString(solution(new int[]{29, 25, 17, 24, 4, 27, 7, 19, 29, 14, 23, 4, 21, 3, 8, 14}, new int[]{11, 21, 7, 5, 6, 30, 11, 24, 26, 18, 20, 18, 15, 30, 7, 18})));
    }
    public int [] solution(int [] progresses, int [] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        Stack<Integer> answer = new Stack<>();
        int multi = 0;
        for(int i = 0 ; i < progresses.length; i++) {
            if (progresses[i] < 100) {
                int flag = multi;
                while (progresses[i] < 100) {
                    progresses[i] += speeds[i];
                    multi++;
                }
                for (int j = i + 1; j < progresses.length; j++) {
                    progresses[j] += (speeds[j] * (multi - flag));
                }
                queue.offer(multi);
            } else
                queue.offer(multi);
        }
        answer.push(1);
        while(queue.size() != 0) {
            int flag = queue.poll();
            if(queue.size() != 0 && flag == queue.peek()) {
                int tmp = answer.pop();
                answer.push(tmp+1);
            }
            else if(queue.size() != 0) answer.push(1);
        }
        return answer.stream().mapToInt(i->i).toArray();
    }
}
