// 9 Score
package level_1;

public class Solve_14 {
    public static void main(String[] args) {
        Solve_14 sol = new Solve_14();
    }
    private Solve_14() {
        System.out.println(solution("AB",1));
        System.out.println(solution("z",1));
        System.out.println(solution("a B z", 4));
    }
    public String solution(String s, int n) {
        char [] flag = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if(flag[i] == ' ')
                continue;
            if(Character.isUpperCase(flag[i]) && flag[i] + n > 90) {
                flag[i] -= 26;
            }
            else if(Character.isLowerCase(flag[i]) && flag[i] + n > 122) {
                flag[i] -= 26;
            }
            flag[i] += n;
        }
        return String.copyValueOf(flag);
    }
}
