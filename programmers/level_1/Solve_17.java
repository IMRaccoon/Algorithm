// 2 Score
package level_1;

public class Solve_17 {
    public static void main(String[] args) {
        Solve_17 sol = new Solve_17();
    }
    private Solve_17() {
        System.out.println(solution(123));
        System.out.println(solution(987));
    }
    public int solution(int n) {
        int answer = 0;
        double i = Integer.toString(n).length() - 1;
        do {
            answer += (int)(n / Math.pow((double)10, i));
            n -= (int)(n / Math.pow((double)10, i)) * Math.pow((double)10, i);
            i--;
        }while(i != -1);
        return answer;
    }
}
