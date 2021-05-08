// 2 Score
package stack_queue;

import java.util.LinkedList;

public class Printer {
    public static void main(String[] args) {
        Printer p = new Printer();
    }
    private Printer() {
        //System.out.println(solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
    public int solution(int [] priorities, int location) {
        int answer = 0;
        int output;
        LinkedList<Integer> list = new LinkedList<>();
        int size = priorities.length;
        for (int a : priorities)
            list.add(a);
        while(size != 0) {
            output = list.removeFirst();
            if(check(list, output)) {
                answer += 1;
                size -= 1;
                if(location == 0)
                    return answer;
                else
                    location-=1;
            }
            else {
                list.add(output);
                if(location == 0)
                    location = list.size()-1;
                else
                    location-=1;
            }

        }
        return answer;
    }
    public boolean check(LinkedList<Integer> list, int output) {
        for(int i = list.size()-1; i >= 0; i--) {
            if(output < list.get(i))
                return false;
        }
        return true;
    }
}
