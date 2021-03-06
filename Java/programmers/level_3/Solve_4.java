// 6 Score
package level_3;

public class Solve_4 {
    public static void main(String[] args) {
        Solve_4 sol = new Solve_4();
    }
    private Solve_4() {
        System.out.println(solution(4));
        System.out.println(solution(3));
    }
    public int solution(int n) {
        int [] arr = new int [n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < n+1; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= 1234567;
        }
        return arr[n];
    }
}
