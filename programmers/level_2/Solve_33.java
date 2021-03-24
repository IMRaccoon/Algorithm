// 9 Score
package level_2;

public class Solve_33 {
    public static void main(String[] args) {
        Solve_33 sol = new Solve_33();
    }
    private Solve_33() {
        System.out.println(solution("()()"));
        System.out.println(solution("(())()"));
        System.out.println(solution(")()("));
        System.out.println(solution("(()("));
    }
    public boolean solution(String s) {
        char [] arr = s.toCharArray();
        int check = 0;
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] == '(')
                check += 1;
            else if(arr[i] == ')')
                check -= 1;
            if(check < 0)
                return false;
        }
        if(check != 0)
            return false;
        return true;
    }
}
