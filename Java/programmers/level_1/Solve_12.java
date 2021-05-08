// 3 Score
package level_1;

public class Solve_12 {
    public static void main(String [] args) {
        Solve_12 sol = new Solve_12();
    }
    private Solve_12() {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
    public String solution(int n) {
        String answer = "";
        for(int i =0; i<n; i++) {
            if(i%2 == 0)
                answer = answer.concat("S");
            else
                answer = answer.concat("B");
        }
        return answer;
    }
}
