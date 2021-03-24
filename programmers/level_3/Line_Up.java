// 6 Score
package level_3;

import java.util.Arrays;
import java.util.LinkedList;

public class Line_Up {
    public static void main(String[] args) {
        Line_Up LU = new Line_Up();
    }
    private Line_Up() {
        System.out.println(Arrays.toString(solution(3, 5)));
        System.out.println(Arrays.toString(solution(4, 11)));
    }
    public int[] solution(int n, long k) {
        int [] answer = new int[n];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 0 ; i<n; i++)
            list.add(i+1);
        long fac= 1;
        int flagN = n;
        k--;
        for(int i = 2; i<n ;i++)
            fac *= i;
        while(flagN != 1) {
            answer[n-flagN] = list.remove((int)(k / fac));
            k -= fac * (k/fac);
            fac /= --flagN;
        }
        answer[n-1] = list.remove();
        return answer;
    }
}