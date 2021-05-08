// 10 Score
package level_3;

import java.util.Arrays;

public class Solve_5 {
    public static void main(String[] args) {
        Solve_5 sol = new Solve_5();
    }
    private Solve_5() {
        System.out.println(solution(4, new int[]{4, 3, 3}));
        System.out.println(solution(1, new int[]{2, 1, 2}));
        System.out.println(solution(3, new int[]{1, 1, 5, 5}));
    }
    public long solution(int n, int [] works) {
        long answer = 0;
        Arrays.sort(works);
        recursive(works.length-1, n, works);
        for(int i = 0; i < works.length; i++) {
            if(works[i] < 0)
                works[i] = 0;
            answer += works[i] * works[i];
        }
        return answer;
    }
    public int recursive(int index, int n, int [] works) {
        if(index == 0) {
            int a = 0;
            while(n != 0) {
                if(a == works.length)
                    a = 0;
                works[a] -= 1;
                n --;
                a ++;
            }
            return 0;
        }
        else if(works[index] == works[index-1])
            return recursive(index-1,n,works);
        else {
            int min = works[index-1];
            while(n != 0 && min != works[works.length-1]) {
                for(int i = index; i<works.length && n != 0; i++) {
                    n -= 1;
                    works[i] -= 1;
                }
            }
            if(n == 0)
                return 0;
            else
                return recursive(index-1, n, works);
        }
    }
}
