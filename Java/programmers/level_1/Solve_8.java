// 4 Score
package level_1;

import java.util.Arrays;

public class Solve_8 {
    public static void main(String [] args) {
        Solve_8 sol = new Solve_8();
    }
    private Solve_8() {
        System.out.println(solution("Zbcdfg"));
        System.out.println(solution("Zbcfg"));
    }
    public String solution(String s) {
        char [] answer = new char[s.length()];
        char flag;
        for(int i =0; i<s.length(); i++)
            answer[i] = s.charAt(i);
        Arrays.sort(answer);
        for(int i = 0; i<answer.length/2; i++) {
            flag = answer[i];
            answer[i] = answer[answer.length - i - 1];
            answer[answer.length-i-1] = flag;
        }
        return String.copyValueOf(answer);
    }
}
