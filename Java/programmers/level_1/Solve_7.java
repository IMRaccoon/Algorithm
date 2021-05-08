// 5 Score
package level_1;

public class Solve_7 {
    public static void main(String[] args) {
        Solve_7 sol = new Solve_7();
    }
    private Solve_7() {
        System.out.println(solution("pPoooyY"));
        System.out.println(solution("Pyy"));
    }

    public boolean solution(String s) {
        int pNum = 0;
        int yNum = 0;
        for(int i =0; i<s.length(); i++) {
            if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pNum++;
            else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') yNum++;
        }
        if(pNum == yNum) return true;
        else return false;
    }

}
