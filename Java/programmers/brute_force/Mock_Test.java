// 1 Score
package brute_force;

import java.util.Arrays;

public class Mock_Test {
    public static void main(String[] args) {
        Mock_Test MT = new Mock_Test();
    }
    private Mock_Test() {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
    }

    public int[] solution(int[] answers) {
        int [] second = new int[] {2,1,2,3,2,4,2,5};
        int [] third = new int[] {3,3,1,1,2,2,4,4,5,5};
        int length = answers.length;
        int [] score = new int[3];
        for(int i = 0 ; i < length; i++) {
            if(answers[i] == (i % 5) + 1) score[0] ++;
            if(answers[i] == second[i%8]) score[1] ++;
            if(answers[i] == third[i%10]) score[2] ++;
        }
        if(score[0] > score[1]) {
            if(score[0] > score[2]) return new int[] {1};
            else if(score[0] == score[2]) return new int[] {1, 3};
            else return new int[] {3};
        }
        else if(score[0] == score[1]) {
            if(score[1] > score[2]) return new int[] {1,2};
            else if(score[1] == score[2]) return new int[] {1,2,3};
            else return new int[] {3};
        }
        else {
            if(score[1] == score[2]) return new int[] {2,3};
            else if(score[1] > score[2]) return new int[] {2};
            else return new int[] {3};
        }
    }
}
