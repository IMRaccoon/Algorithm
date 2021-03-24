// 4 Score
package level_3;
import java.util.Arrays;

public class Bestest_Set {
    public static void main(String[] args) {
        Bestest_Set BS = new Bestest_Set();
    }
    private Bestest_Set() {
        System.out.println(Arrays.toString(solution(2, 9)));
        System.out.println(Arrays.toString(solution(2, 1)));
    }
    public int[] solution(int n, int s) {
        if(s < n) return new int[] {-1};
        int div = Math.floorDiv(s, n);
        int rest = Math.floorMod(s, n);
        int [] answer = new int[n];
        for(int i =0; i<n-rest; i++)
            answer[i] = div;
        div += 1;
        for(int i = n-rest; i< n; i++)
            answer[i] = div;
        return answer;
    }
}
