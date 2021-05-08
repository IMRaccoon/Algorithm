// 5 Score
package level_3;

public class Tiling_2n {
    public static void main(String[] args) {
        Tiling_2n t2 = new Tiling_2n();
    }

    private Tiling_2n() {
        for(int i = 59000; i< 60000; i++) {
            System.out.println(solution(i));
        }
    }
    public int solution(int n) {
        if(n == 1 || n == 2)
            return n;
        int a = 1, b = 2;
        for(int i = 0 ; i < (n-1) /2; i++) {
            a = (a+b) % 1000000007;
            b = (a+b) % 1000000007;
        }
        return n % 2 == 0 ? b : a;
    }
}
