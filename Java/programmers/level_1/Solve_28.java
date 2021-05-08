// 2 Score
package level_1;

import java.util.Arrays;

public class Solve_28 {
    public static void main(String[] args) {
        Solve_28 sol = new Solve_28();
    }
    private Solve_28() {
        System.out.println(Arrays.deepToString(solution(new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}})));
        System.out.println(Arrays.deepToString(solution(new int[][]{{1}, {2}}, new int[][]{{3}, {4}})));
    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for(int i = 0; i< arr1.length; i++) {
            for(int j = 0; j<arr1[i].length; j++) {
                arr1[i][j] += arr2[i][j];
            }
        }
        return arr1;
    }
}
