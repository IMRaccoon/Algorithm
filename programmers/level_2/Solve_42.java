// 5 Score
package level_2;

import java.util.Arrays;

public class Solve_42 {
    public static void main(String[] args) {
        Solve_42 sol = new Solve_42();
    }
    private Solve_42() {
        System.out.println(solution(new int[]{2, 1, 2, 2}));
        System.out.println(solution(new int[]{2, 1, 4, 2}));
        System.out.println(solution(new int[]{1, 1, 1, 1}));
        System.out.println(solution(new int[]{2, 5, 30, 35}));
        System.out.println(solution(new int[]{7, 1, 4, 1}));
    }
    public int solution(int [] arr) {
        Arrays.sort(arr);
        int flag = 0;
        while(arr[flag] == 1 && flag != arr.length-1) flag += 1;
        int answer = arr[flag];
        int initial = answer;
        while(flag != arr.length) {
            if(answer % arr[flag] == 0) {
                initial = answer;
                flag += 1;
            }
            else
                answer += initial;
        }
        return answer;
    }
}
