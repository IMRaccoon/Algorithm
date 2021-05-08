// 11 Score
package level_1;

import java.util.Arrays;
import java.util.Comparator;

public class Solve_6 {
    public static void main(String [] args) { Solve_6 sol = new Solve_6();}
    private Solve_6 () {
        System.out.println(Arrays.toString(solution(new String[]{"sun", "bud", "car"}, 1)));
        System.out.println(Arrays.toString(solution(new String[]{"abce", "abcd", "cdx"}, 2)));
    }
    public String[] solution(String [] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, Comparator.comparingInt(o -> o.charAt(n)));
        return strings;
    }
}
