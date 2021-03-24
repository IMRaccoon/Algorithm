// 6 Score
package level_1;
import java.util.Arrays;

public class Solve_21 {
    public static void main(String[] args) {
        Solve_21 sol = new Solve_21();
    }
    private Solve_21() {
        System.out.println(Arrays.toString(solution(new int[] {-2,4,3,2,1,5,6,7,11,-1,12,13,14,15,16,4,17,18,19,-4})));
        System.out.println(Arrays.toString(solution(new int[] {0, -2})));
    }
    public int[] solution (int [] arr) {
        int [] answer = new int[arr.length-1];
        int min = arr[0], minIndex = 0;
        if(arr.length == 1)
            return new int[] {-1};
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]) {
                minIndex = i;
                min = arr[i];
            }
        }
        for (int i = 0, j = 0; i < answer.length; i++, j++) {
            if (j == minIndex)
                j += 1;
            answer[i] = arr[j];
        }

        return answer;
    }
}
