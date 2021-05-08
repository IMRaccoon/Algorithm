// 3 Score
package level_1;

public class Solve_10 {
    public static void main(String [] args) {
        Solve_10 sol = new Solve_10();
    }
    private Solve_10() {
        System.out.println(solution(new String[] {"Jane","Lim","Kim"}));
    }
    public String solution(String[] seoul) {
        int flag = 0;
        while(flag != seoul.length) {
            if(seoul[flag].equals("Kim"))
                break;
            else flag += 1;
        }
        return "김서방은 "+flag+"에 있다";

    }
}
