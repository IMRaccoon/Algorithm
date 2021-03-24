// 2 Score
package level_1;

public class Solve_22 {
    public static void main(String[] args) {
        Solve_22 sol = new Solve_22();
    }
    private Solve_22() {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
    public String solution(int num) {
        return num%2 == 0 ? "Even" : "Odd";
    }
}
