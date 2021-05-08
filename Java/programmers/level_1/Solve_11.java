// 17 Score
package level_1;

public class Solve_11 {
    public static void main(String [] args) {
        Solve_11 sol = new Solve_11();
    }
    private Solve_11() {
        System.out.println(solution(10));
        System.out.println(solution(4));
    }
    public int solution(int n) {
        int answer = 0;
        boolean isDivide;
        for(int i = 2 ; i <= n; i++) {
            isDivide = true;
            for(int j = 2; j <= Math.sqrt(i) ; j++) {
                if(i % j == 0) {
                    isDivide = false;
                    break;
                }
            }
            if(isDivide)
                answer += 1;
        }
        return answer;
    }
}
