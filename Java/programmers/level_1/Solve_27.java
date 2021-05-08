// 1 Score
package level_1;

public class Solve_27 {
    public static void main(String[] args) {
        Solve_27 sol = new Solve_27();
    }
    private Solve_27() {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
        System.out.println(solution("2288"));
    }
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < phone_number.length()-4; i++) answer.append("*");
        answer.append(phone_number.substring(phone_number.length() - 4));
        return answer.toString();
    }
}
