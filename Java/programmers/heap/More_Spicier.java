// 5 Score
package heap;

import java.util.PriorityQueue;

public class More_Spicier {
    public static void main(String[] args) {
        More_Spicier MS = new More_Spicier();
    }

    private More_Spicier() {
        System.out.println(solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
        System.out.println(solution(new int[]{1, 2, 3, 10, 9, 12}, 7));
    }

    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 0;
        for(int a : scoville) queue.add(a);
        while(queue.peek() < K && queue.size() != 1) {
            queue.add(queue.poll() + (queue.poll() * 2));
            count ++;
        }
        if(queue.peek() >= K) return count;
        else return -1;
    }
}
