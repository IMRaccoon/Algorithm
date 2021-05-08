package Skill_Check;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class level2_problem3 {
    public static void main(String[] args) {
        level2_problem3 lp3 = new level2_problem3();
    }
    level2_problem3() {
        System.out.println(Arrays.toString(solution(new int[] {1,2,3,2,3})));
    }
    public int[] solution(int [] prices) {
        int length = prices.length;
        int answer[] = new int[length];
        Data_set[] data = new Data_set[length];
        Queue<Data_set> queue = new ArrayDeque<>();
        for(int i = 0 ; i<length; i++) {
            data[i] = new Data_set();
            data[i].prices = prices[i];
            data[i].index = i;
            for(int j = queue.size(); j > 0; j--) {
                if(queue.peek().prices <= data[i].prices) {
                    queue.peek().answer += 1;
                    queue.offer(queue.poll());
                }
                else {
                    answer[queue.peek().index] = queue.peek().answer+1;
                    queue.poll();
                }
            }
            queue.offer(data[i]);
        }
        while(!queue.isEmpty()) {
            answer[queue.peek().index] = queue.poll().answer;
        }
        return answer;
    }
    class Data_set {
        int prices;
        int answer;
        int index;
    }
}
