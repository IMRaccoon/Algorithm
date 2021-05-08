// 4 Score
package level_1;

import java.util.Arrays;

public class Solve_19 {
    public static void main(String[] args) {
        Solve_19 sol = new Solve_19();
    }
    private Solve_19() {
        System.out.println(solution(118372));
        System.out.println(solution(11832));
    }
    public long solution(long n) {
        long answer = 0;
        int length = String.valueOf(n).length();
        int [] array = new int[length];
        for(int i = 0; i<length; i++) {
            array[i] = (int)(n / Math.pow(10, length - i -1));
            n -= array[i] * Math.pow(10, length - i - 1);
        }
        Arrays.sort(array);
        for(int i = 0; i < length/2; i++) {
            int temp = array[i];
            array[i] = array[length-i-1];
            array[length-i-1] = temp;
        }
        for(int i = 0; i < length; i++)
            answer += array[i] * Math.pow(10, length-i-1);
        return answer;
    }
}
