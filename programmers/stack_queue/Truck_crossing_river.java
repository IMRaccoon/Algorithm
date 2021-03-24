// 3 ScoreK
package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class Truck_crossing_river {
    public static void main(String[] args) {
        Truck_crossing_river TCR = new Truck_crossing_river();
    }
    private Truck_crossing_river() {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution(100, 100, new int[]{10}));
        System.out.println(solution(100, 100, new int[]{10,10,10,10,10,10,10,10,10,10}));
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int length = truck_weights.length;
        Queue<Integer> queue = new LinkedList<>();
        int truck_num = 1;                  // 버스 위 트럭 index
        int truck_start = 0;                // 탈출한 트럭 index
        int truck_weight = truck_weights[0];      // total weight
        queue.offer(bridge_length);
        while(!queue.isEmpty()) {
            answer += 1;
            int size = queue.size();
            for(int i = 0 ; i< size; i++) {
                queue.offer(queue.poll()-1);
            }
            if(queue.peek() == 0) {
                queue.poll();
                truck_weight -= truck_weights[truck_start];
                truck_start += 1;
            }
            if(truck_num != length && truck_weight + truck_weights[truck_num] <= weight) {
                queue.offer(bridge_length);
                truck_num += 1;
                truck_weight += truck_weights[truck_num-1];
            }
        }
        return answer+1;
    }
}
