// 1 Score
package stack_queue;

public class Stick {
    public static void main(String[] args) {
        Stick st = new Stick();
    }
    private Stick() {
        System.out.println(solution("()(((()())(())()))(())"));
    }
    public int solution(String arrangement) {
        int answer = 0;
        int length = arrangement.length();
        int sticks = 0;
        for(int i = 0 ; i<length; i++) {
            char state = arrangement.charAt(i);
            if(state == '(') {
                if(arrangement.charAt(i+1) == ')') {
                    answer += sticks;
                    i++;
                }
                else
                    sticks += 1;
            }
            else if(state == ')') {
                answer += 1;
                sticks -= 1;
            }
        }
        return answer + sticks;
    }
}
