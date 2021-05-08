// 5 Score
package greedy;

import java.util.ArrayList;
import java.util.Stack;

public class Workout_Clothes {
    public static void main(String[] args) {
        Workout_Clothes WC = new Workout_Clothes();
    }
    private Workout_Clothes() {
        System.out.println(solution(5, new int[]{2, 4}, new int[]{1, 3, 5}));
        System.out.println(solution(5, new int[]{2, 4}, new int[]{3}));
    }
    public int solution(int n, int [] lost, int [] reserve) {
        int answer = n - lost.length;
        ArrayList<Integer> lostPerson = new ArrayList<>();
        for(int i : lost) lostPerson.add(i);
        Stack<Integer> reservePerson = new Stack<>();
        for(int i : reserve) reservePerson.push(i);
        while(!lostPerson.isEmpty() && !reservePerson.isEmpty()) {
            int helper = reservePerson.pop();
            if(lostPerson.remove((Object)helper) || lostPerson.remove((Object)(helper+1)) || lostPerson.remove((Object)(helper-1)))
                answer += 1;
        }
        return answer;
    }
}
