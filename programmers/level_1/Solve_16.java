// 14 Score
package level_1;
public class Solve_16 {
    public static void main(String[] args) {
        Solve_16 sol = new Solve_16();
    }
    private Solve_16() {
        System.out.println(solution(" b  tRYs   HEllo  world                 "));
    }
    public String solution(String s) {
        char [] sol = s.toCharArray();
        for(int i = 0, j = 0; j<s.length(); i++, j++) {
            while(sol[j] == ' ' && j < s.length()-1) {
                j++;
                i = 0;
            }
            if(i % 2 == 0)
                sol[j] = Character.toUpperCase(sol[j]);
            else if(i % 2 != 0)
                sol[j] = Character.toLowerCase(sol[j]);
        }
        return String.copyValueOf(sol);
    }
}
