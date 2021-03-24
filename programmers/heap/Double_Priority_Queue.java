// 1 Score
package heap;

import java.util.*;


public class Double_Priority_Queue {
    public static void main(String[] args) {
        Double_Priority_Queue DPQ = new Double_Priority_Queue();
    }
    private Double_Priority_Queue() {
        System.out.println(Arrays.toString(solution(new String[] {"I 16", "D 1"})));
        System.out.println(Arrays.toString(solution(new String[] {"I 7", "I 5", "I-5", "D-1"})));
    }
    public int[] solution1(String[] operations) {
        int[] answer = new int[2];
        int length = operations.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        PriorityQueue<Integer> reversedPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        int number;
        for(int i = 0; i< length; i++) {
            if(operations[i].charAt(0) == 'I') {
                number = Integer.parseInt(operations[i].substring(2));
                queue.offer(number);
            }
            else {
                int size = queue.size();
                if(size == 0);
                else if(operations[i].charAt(2) == '-')
                    queue.poll();
                else {
                    reversedPriorityQueue.addAll(queue);
                    reversedPriorityQueue.poll();
                    queue.removeAll(queue);
                    queue.addAll(reversedPriorityQueue);
                    reversedPriorityQueue.removeAll(reversedPriorityQueue);
                }
            }
        }
        try {
            answer[1] = queue.poll();
        } catch (NullPointerException e) {
            return new int[]{0,0};
        }
        reversedPriorityQueue.addAll(queue);
        try {
            answer[0] = reversedPriorityQueue.poll();
        }catch (NullPointerException e) {
            return new int[]{answer[1], answer[1]};
        }
        return answer;
    }
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        int length = operations.length;
        LinkedList<Integer> list = new LinkedList<>();
        int number;
        for(int i = 0; i< length; i++) {
            if(operations[i].charAt(0) == 'I') {
                number = Integer.parseInt(operations[i].substring(2));
                list = addPriority(list, number);
            }
            else {
                int size = list.size();
                if(size == 0);
                else if(operations[i].charAt(2) == '-')
                    list.removeLast();
                else {
                    list.removeFirst();
                }
            }
        }
        try {
            answer[0] = list.getFirst();
        } catch (NoSuchElementException e) {
            return new int[] {0, 0};
        }
        try {
            answer[1] = list.getLast();
        } catch (NoSuchElementException e) {
            return new int[] {answer[0], answer[0]};
        }
        return answer;
    }
    private LinkedList addPriority(LinkedList<Integer> list, int number) {
        int size = list.size();
        if(size != 0) {
            for(int i = 0 ; i<size;i++) {
                if(list.get(i) < number) {
                    list.add(i, number);
                    return list;
                }
            }
        }
        list.add(number);
        return list;
    }
}
