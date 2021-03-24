package Skill_Check;

import java.util.ArrayDeque;
import java.util.Queue;

public class level2_problem2 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[] {7,4,5,6}));
    }
    public static int solution(int bridge_length, int weight, int [] truck_weights) {
        int answer = 0;
        int presentWeight = 0;
        int index = 0;
        Queue<int[]> bridge = new ArrayDeque<>();
        if(index < truck_weights.length && presentWeight + truck_weights[index] <= weight){
            presentWeight += truck_weights[index];
            bridge.offer(new int[]{truck_weights[index++], 0});
        }

        while(!bridge.isEmpty()) {
            for(int i = 0 ; i < bridge.size(); i++) {
                if(bridge.peek()[1]+1 > bridge_length){
                    presentWeight -= bridge.peek()[0];
                    bridge.poll();
                }
                else {
                    bridge.offer(new int[] {bridge.peek()[0], bridge.peek()[1] + 1});
                    bridge.poll();
                }
            }
            if(index < truck_weights.length && presentWeight + truck_weights[index] <= weight){
                presentWeight += truck_weights[index];
                bridge.offer(new int[]{truck_weights[index++], 1});
            }
            answer += 1;
        }
        return answer;
    }
}
