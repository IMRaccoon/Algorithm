// 3 Score
package sort;

import java.util.Arrays;

public class H_Index {
    public static void main(String[] args) {
        H_Index HI = new H_Index();
    }
    private H_Index() {
        System.out.println(solution(new int[]{3,0,6,1,5}));
        System.out.println(solution(new int[]{0,0,0,0}));
        System.out.println(solution(new int[]{22,42}));
    }
    public int solution(int [] citations) {
        int answer = 0;
        int length = citations.length;
        Integer [] sort = new Integer[length];
        for(int i = 0; i<length; i++) sort[i] = citations[i];
        Arrays.sort(sort, (o1, o2) -> {
            if(o1 >= o2) return -1;
            else return 1;
        });
        if(sort[0] == 0) return 0;
        for(int i =0 ; i<length-1; i++) {
            if(sort[i] >= i+1) {
                if(sort[i+1] <= i+1) return i+1;
                else answer = i+1;
            }
        }
        return answer + 1;
    }
}
