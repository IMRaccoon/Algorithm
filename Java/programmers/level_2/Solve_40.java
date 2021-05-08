// 7 Score
package level_2;

public class Solve_40 {
    public static void main(String[] args) {
        Solve_40 sol = new Solve_40();
    }
    private Solve_40() {
        System.out.println(solution(new int[][]{{1, 4}, {3, 2}, {4, 1},}, new int[][]{{3, 3}, {3, 3}}).toString());
        System.out.println(solution(new int[][]{{2, 3, 2}, {4, 2, 4}, {3, 1, 4}}, new int[][]{{5, 4, 3}, {2, 4, 1}, {3, 1, 1}}).toString());
    }
    public int [][] solution(int [][] arr1, int [][] arr2) {
        int [][] answer = new int[arr1.length][arr2[0].length];
        System.out.println(arr1.length + " " +arr2[0].length);
        for(int i = 0 ;i<arr1.length; i++) {
            for(int j = 0; j<arr2[0].length; j++) {
                for(int k = 0 ; k<arr1[0].length; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}
