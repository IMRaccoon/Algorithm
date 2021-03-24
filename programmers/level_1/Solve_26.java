// 1 Score

package level_1;

public class Solve_26 {
    public static void main(String[] args) {
        Solve_26 sol = new Solve_26();
    }
    private Solve_26() {
        System.out.println(solution(10));
        System.out.println(solution(12));
        System.out.println(solution(11));
        System.out.println(solution(13));
    }
    public boolean solution(int x) {
        String flag = Integer.toString(x);
        int sum = 0;
        for(int i = 0; i<flag.length(); i++) {
            sum += flag.charAt(i) - '0';
        }
        return x % sum == 0;
    }
}
