package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*\
저울추의 개수는 1개 이상 10,000개 이하입니다.
각 추의 무게는 1 이상 1,000,000 이하입니다.
 */
public class Scale {
    public static void main(String[] args) {
        Scale S = new Scale();
    }
    private Scale() {
        System.out.println(solution(new int[]{3, 1, 6, 2, 7, 30, 1}));
    }
    public int solution(int [] weight) {
        Arrays.sort(weight);            // 1, 1, 2, 3, 6, 7, 30
        List<Integer> list = new LinkedList<>();
        for(int a : weight) list.add(a);
        int limit = 1;
        while(true) {                   // 1, 2, 4, 8 ... 조합을 통해 만들 수 있는 숫자들을 확인한다.
            if(list.contains(limit)){
                list.remove(limit);
                limit *= 2;
            }
            else {

            }
            break;
        }
        return 1;
    }
}
