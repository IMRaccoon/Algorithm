// 7 Score
package level_2;

public class Solve_36 {
    public static void main(String[] args) {
        Solve_36 sol = new Solve_36();
    }
    private Solve_36() {
        System.out.println(solution(15));
    }
    public int solution(int n) {
        int answer = 1;                     // 자기 자신
        if(n % 2 == 1 && n != 1)                      // 홀 수의 경우
            answer += 1;
        for(int i = 2 ;i <= Math.sqrt(n); i++) {     // 약수를 찾아야 함
            if(n % i == 0) {
                if (i % 2 == 1)
                    answer += 1;
                if ((n / i) % 2 == 1 && (n / i) != i)
                    answer += 1;
            }
        }
        return answer;
    }
}
