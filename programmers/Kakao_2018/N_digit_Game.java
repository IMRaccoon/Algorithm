// 2 Score
package Kakao_2018;

public class N_digit_Game {
    public static void main(String[] args) {
        N_digit_Game NG = new N_digit_Game();
    }
    private N_digit_Game() {
        System.out.println(solution(2, 4, 2, 1));
        System.out.println(solution(16, 16, 2, 1));
        System.out.println(solution(16, 16, 2, 2));
    }
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        String realAnswer = "";
        StringBuffer flag1 = new StringBuffer();
        int flag = 0, flag2 = 0;
        final char[] digit = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] realDigit = new char[n];
        for (int i = 0; i < n; i++)
            realDigit[i] = digit[i];
        while(flag != (t * m)) {
            while(Math.floorDiv(flag2, n) != 0) {
                flag1.append(digit[flag2%n]);
                flag2 /= n;
            }
            flag1.append(digit[flag2]);
            flag2 = ++flag;
            answer += flag1.reverse();
            flag1 = new StringBuffer();
        }
        for(int i = 0; i< t; i ++) {
            realAnswer += answer.charAt(m * i + p -1);
        }
        return realAnswer;
    }
}
