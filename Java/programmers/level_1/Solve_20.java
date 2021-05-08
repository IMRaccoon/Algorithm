// 8 Score
package level_1;

public class Solve_20 {
    public static void main(String[] args) {
        Solve_20 sol = new Solve_20();
    }
    private Solve_20() {
        System.out.println(solution(121));
        System.out.println(solution(3));
    }
    public long solution(long n) {
        for(int i = 1; i<= Math.sqrt((double)n); i++) {
            if(n / i == i && n % i == 0)
                return (long)Math.pow(i+1, 2);
        }
        return -1;
    }

}
