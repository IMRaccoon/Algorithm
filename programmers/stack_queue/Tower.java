// 1 Score
package stack_queue;

import java.util.Arrays;
import java.util.Stack;

public class Tower {
    public static void main(String[] args) {
        Tower tower = new Tower();
    }
    private Tower() {
        System.out.println(Arrays.toString(solution(new int[]{6, 9, 5, 7, 4})));
        System.out.println(Arrays.toString(solution(new int[]{3, 9, 9, 3, 5, 7, 2})));
        System.out.println(Arrays.toString(solution(new int[]{1, 5, 3, 6, 7, 6, 5})));
    }
    public int [] solution(int [] height) {
        int length = height.length;
        int [] answer = new int[length];
        int flag;
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i<length; i++) {    // initialization
            st.push(height[i]);
            answer[i] = 0;
        }
        for(int i = length-1; i>=0; i--) {
            flag = st.pop();
            for(int j = i; j >= 0; j--) {
                if(flag < height[j]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }
        return answer;
    }
}
