// 10 Score
package level_1;

public class Solve_9 {
    public static void main(String [] args) {
        Solve_9 sol = new Solve_9();
    }
    private Solve_9() {
        System.out.println(solution("a1234"));
        System.out.println(solution("1234"));
    }
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() == 4 || s.length() == 6) {
            for(int i = 0; i<s.length(); i++) {
                if(Character.isAlphabetic(s.charAt(i)))
                    answer = false;
            }
        }
        else answer = false;
        return answer;
    }
}
