// 9 Score
package level_2;

public class Solve_39 {
    public static void main(String[] args) {
        Solve_39 sol = new Solve_39();
    }
    private Solve_39() {
        for(int i = 1 ; i<10; i++) {
            System.out.println(solution(i));
        }
    }
    public int solution(int n) {
        int [] arr = new int [n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i = 2; i < n+1; i++) {
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= 1234567;
        }
        return arr[n-1];
    }
}
