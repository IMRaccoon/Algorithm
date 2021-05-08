// 2 Score
package stack_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Stock_Prices {
    public static void main(String[] args) {
        Stock_Prices SP = new Stock_Prices();
    }
    private Stock_Prices() {
        System.out.println(Arrays.toString(solution(new int[]{498, 501, 470, 489})));
    }
    public int[] solution(int[] prices) {
        int length = prices.length;
        int[] answer = new int[length];
        int [] data;
        Queue<int []> queue = new ArrayDeque<>();
        for(int i = 0 ; i<length; i++) {
            data = new int[] {prices[i], i};
            int queueSize = queue.size();
            for(int j = 0 ; j< queueSize; j++) {
                int [] flag = queue.poll();
                if(flag[0] <= data[0]) {
                    queue.offer(flag);
                }
                answer[flag[1]] += 1;
            }
            queue.offer(data);
        }
        return answer;
    }
}