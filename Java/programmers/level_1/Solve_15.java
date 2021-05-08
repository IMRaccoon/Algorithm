// 4 Score
package level_1;

public class Solve_15 {
    public static void main(String[] args) {
        Solve_15 sol = new Solve_15();
    }
    private Solve_15() {
        System.out.println(solution(12));
        System.out.println(solution(5));
    }
    public int solution(int n) {
        int answer = 0;
        for(int i =1; i<=n/2; i++) {
            if(n %i == 0)
                answer += i;
        }
        return answer + n;
    }
}
