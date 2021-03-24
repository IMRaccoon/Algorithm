// 8 Score
package level_1;

public class Solve_24 {
    public static void main(String[] args) {
        Solve_24 sol = new Solve_24();
    }
    private Solve_24() {
        System.out.println(solution(6));
        System.out.println(solution(16));
        System.out.println(solution(9999999));
    }
    public int solution(int num) {
        return recursive(num , 0);
    }
    private int recursive(long num, int n) {
        if (num == 1) return n;
        else if (n == 499) return -1;
        else if (num % 2 == 0)
            return recursive(num / 2, n + 1);
        else if (num % 2 == 1)
            return recursive(num * 3 + 1, n + 1);
        return n;
    }
}
