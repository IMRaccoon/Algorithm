package Skill_Check;

import java.util.Arrays;


public class level2_problem5 {
    public static void main(String[] args) {
        level2_problem5 level2_problem5 = new level2_problem5();
    }
    public level2_problem5() {
        System.out.println(Arrays.toString(solution(new int[]{3,9,9,3,5,7,2})));
    }
    private int[] solution(int[] heights) {
        int length = heights.length;
        int [] answer = new int[length];
        int heightest = length-1;
        for(int i = length-1; i >= 0; i--) {
            for(int j = i >= heightest ? heightest : i; j >= 0; j--) {
                if(i != j && heights[i] < heights[j]) {
                    heightest = j;
                    answer[i] = j+1;
                    break;
                }
            }
        }
        return answer;
    }
}
