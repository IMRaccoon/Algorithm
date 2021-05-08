// 5 Score
package greedy;

public class Joystick {
    public static void main(String[] args) {
        Joystick J = new Joystick();
    }
    private Joystick() {
        //System.out.println(solution("JEROEN"));         // 56
        System.out.println(solution("JAN"));            // 23
        System.out.println(solution("JAAN"));           // 23
        System.out.println(solution("ABAAAB"));         // 5
        System.out.println(solution("BAAAA"));         // 2
    }
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        for(int i =0  ; i < length; i++) {
            if(name.charAt(i) == 'A') {
                int j = i;
                while(name.charAt(j) == 'A' && j != name.length()-1) {j++;}
                if(j == name.length()-1 && name.charAt(j) == 'A') return answer;
                if((j-i) > i && i == 0) answer += 1;
                else if((j-i) >= i) answer += (i - 1);
                else answer += (j-i);
                i = j - 1;
            }
            else {
                answer +=  name.charAt(i) - 'A' > 'Z' - name.charAt(i) + 1 ? 'Z' - name.charAt(i) + 2 : name.charAt(i) - 'A' + 1;
            }
        }
        return answer - 1;
    }
}
