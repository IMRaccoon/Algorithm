// 8 Score
package level_1;
import java.util.Arrays;

public class Solve_18 {
    public static void main(String[] args) {
        Solve_18 sol = new Solve_18();
    }
    private Solve_18() {
        System.out.println(Arrays.toString(solution(12345)));
    }
    public int [] solution(long n) {
        String a = String.valueOf(n);
        int [] answer = new int[a.length()];
        for(int i = a.length()-1; i>=0; i--) {
            answer[i] = (int)(n / Math.pow(10,i));
            n -= (int)(n / Math.pow(10,i)) * Math.pow(10,i);
        }
        return answer;
    }

}
