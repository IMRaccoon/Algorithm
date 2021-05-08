// 3 Score
package level_1;

import java.util.Arrays;

public class Solve_23 {
    public static void main(String[] args) {
        Solve_23 sol = new Solve_23();
    }
    private Solve_23() {
        System.out.println(Arrays.toString(solution(12, 3)));
        System.out.println(Arrays.toString(solution(2, 5)));
    }
    public int[] solution(int n, int m) {
        if(n>m) {int flag = n; n = m; m = flag;}
        int [] answer = new int[2];
        for(int i = n; i > 0; i--) {
            if(n%i == 0 && m%i == 0){
                answer[0] = i;
                answer[1] = i * (n/i) * (m/i);
                break;
            }
        }
        return answer;
    }
}
