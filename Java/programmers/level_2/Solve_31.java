// 10 Score
package level_2;

public class Solve_31 {
    public static void main(String[] args) {
        Solve_31 sol = new Solve_31();
    }
    private Solve_31() {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
    public String solution(int n) {
        StringBuilder answer = new StringBuilder();
        while(n != 0) {
            if(n % 3 == 0) {
                answer.insert(0, "4");
                n -= 3;
            }
            else if(n % 3 == 1) {
                answer.insert(0, "1");
                n -= 1;
            }
            else if(n % 3 == 2) {
                answer.insert(0, "2");
                n -= 2;
            }
            n /= 3;
        }
        return answer.toString();
    }
}
