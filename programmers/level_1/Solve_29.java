// 7 Score
package level_1;

import java.util.Arrays;

public class Solve_29 {
    public static void main(String[] args) {
        Solve_29 sol = new Solve_29();
    }
    private Solve_29() {
        System.out.println(Arrays.toString(solution(10000000, 1000)));
    }
    public long[] solution(int x, int n) {
        long[] answer = new long[n];
        for(int i =0; i<n; i++)
            answer[i] = ((long)x * (i+1));
        return answer;
    }
}
