// 2 Score
package level_1;

public class Solve_25 {
    public static void main(String[] args) {
        Solve_25 sol = new Solve_25();
    }
    private Solve_25() {
        System.out.println(solution(new int[]{1, 2, 3, 4}));
        System.out.println(solution(new int[]{5, 5}));
    }
    public double solution(int [] arr) {
        int answer = 0;
        for(int i = 0 ; i<arr.length; i++) {
            answer += arr[i];
        }
        return (double)answer / arr.length;
    }
}
