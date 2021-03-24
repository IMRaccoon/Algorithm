package level_2;

import java.util.Arrays;

public class Solve_38 {
    public static void main(String[] args) {
        Solve_38 sol = new Solve_38();
    }
    private Solve_38() {
        System.out.println(solution(new int[]{1, 4, 2}, new int[]{5, 4, 4}));
    }
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        for(int i =0 ;i<A.length; i++)
            answer += A[i] * B[B.length-i-1];
        return answer;
    }
}
