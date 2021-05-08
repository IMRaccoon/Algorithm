// 1 Score

package summer_winter_coding_2019;

import java.util.ArrayList;
import java.util.Arrays;

public class Folding_Paper {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(1)));
        System.out.println(Arrays.toString(solution(2)));
        System.out.println(Arrays.toString(solution(3)));
        System.out.println(Arrays.toString(solution(4)));
    }
    public static int[] solution(int n) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(0);
        for(int i = 1 ; i < n; i++) {
            int size = array.size();
            ArrayList<Integer> new_array = new ArrayList<>();
            for(int j = 0 ; j< size; j ++) {
                if(j % 2 == 0) {
                    new_array.add(0);
                    new_array.add(array.get(j));
                    new_array.add(1);
                }
                else {
                    new_array.add(array.get(j));
                }
            }
            array = new_array;
        }
        return array.stream().mapToInt(i -> i).toArray();
    }
}
