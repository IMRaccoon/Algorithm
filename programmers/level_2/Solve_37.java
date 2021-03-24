package level_2;

import java.util.Arrays;

public class Solve_37 {
    public static void main(String[] args) {

    }
    private Solve_37() {
        System.out.println(solution("1 2 3 4"));
    }
    public String solution(String s) {
        int[] arr = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        return arr[0] + " " + arr[arr.length - 1];
    }
}
