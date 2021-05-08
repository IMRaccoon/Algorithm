// 2 Score
package level_3;

import java.util.Arrays;

public class Hanoi_Tower {
    public static void main(String[] args) {
        Hanoi_Tower HT = new Hanoi_Tower();
    }
    private Hanoi_Tower() {
        int[][] a = solution(3);
        for(int i = 0 ; i<a.length; i++)
            System.out.println(Arrays.toString(a[i]));
    }
    int [][] answer;
    static int count = 0;
    public int[][] solution(int n) {
        int size = 0;
        for(int i = 0 ; i<n; i++)
            size = size * 2 + 1;
        answer = new int[size][2];
        recursive(n, 1, 3);
        return answer;
    }
    private void recursive(int n, int start, int end) {
        if(n > 1) recursive(n-1, start, rest(start, end));
        answer[count++] = new int[] {start, end};
        if(n > 1) recursive(n-1, rest(start, end), end);
    }
    private int rest(int a, int b) {
        if(a + b == 3) return 3;
        else if(a + b == 4) return 2;
        else return 1;
    }
}
