// 4 Score
package level_1;

public class Solve_13 {
    public static void main(String [] args) {
        Solve_13 sol = new Solve_13();
    }
    private Solve_13() {
        System.out.println(solution("+1234"));
        System.out.println(solution("-1234"));
    }
    public int solution(String s) {
        return Integer.valueOf(s);
    }
}
