// 8 Score
package level_2;

public class Solve_41 {
    public static void main(String[] args) {
        Solve_41 sol = new Solve_41();
    }
    private Solve_41() {
        System.out.println(solution("3people unFollowed me"));
        System.out.println(solution("for  the last week"));
    }
    public String solution(String s) {
        char [] answer = s.toCharArray();
        answer[0] = Character.toUpperCase(answer[0]);
        int flag = 1;
        while(flag != s.length()) {
            if(answer[flag] == ' ');
            else if(answer[flag-1] == ' ')
                answer[flag] = Character.toUpperCase(answer[flag]);
            else answer[flag] = Character.toLowerCase(answer[flag]);
            flag += 1;
        }
        return String.valueOf(answer);
    }
}
