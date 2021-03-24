// 1 Score
package sort;

import java.util.Arrays;

public class Kth_Number {
    public static void main(String[] args) {
        Kth_Number KN = new Kth_Number();
    }
    private Kth_Number() {
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
    public int[] solution(int [] array, int [][] commands) {
        int loop = commands.length;
        int arrLength = array.length;
        int [] tmpArr;
        int [] answer = new int[loop];
        for(int i = 0 ; i < loop; i++) {
            tmpArr = Arrays.copyOf(array, arrLength);
            Arrays.parallelSort(tmpArr, commands[i][0]-1, commands[i][1]);
            answer[i] = tmpArr[commands[i][0] + commands[i][2] -2];
        }
        return answer;
    }
}
