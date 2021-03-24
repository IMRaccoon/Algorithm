// 2 Score
package brute_force;

public class Number_Baseball {
    public static void main(String[] args) {
        Number_Baseball NB = new Number_Baseball();
    }
    private Number_Baseball() {
        System.out.println(solution(new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
    }
    public int solution(int [][] baseball) {
        int answer = 0;
        int [][] separate_base = new int[baseball.length][5];
        // Index 0, 1, 2 is digit of number, 3, 4 is strike, ball
        for(int i = 0 ; i<baseball.length; i++) {
            for(int j = 0 ; j<3; j++) {
                separate_base[i][j] = Math.floorDiv(baseball[i][0], (int)Math.pow(10,2-j));
                baseball[i][0] %= separate_base[i][j] * (int)Math.pow(10, 2-j);
            }
            separate_base[i][3] = baseball[i][1];
            separate_base[i][4] = baseball[i][2];
        }
        for(int i = 123; i<= 987; i++)
            if(compare(i, separate_base)) answer ++;
        return answer;
    }
    private boolean compare(int num, int [][] separate_base) {
        int [] separate_num = new int[3];
        int strike, ball;
        int baseball_length = separate_base.length;
        for(int i = 0; i < 3; i++) {            // Separate number
            separate_num[i] = Math.floorDiv(num, (int)Math.pow(10, 2-i));
            if(separate_num[i] == 0) return false;      // Make Exception with 0
            num %= separate_num[i] * (int)Math.pow(10, 2-i);
            for(int j = i-1; j >= 0; j--) {     // Check Duplication in separate_num
                if(separate_num[i] == separate_num[j]) return false;
            }
        }

        for(int i = 0 ; i< baseball_length; i++) {
            strike = 0;
            ball = 0;
            for(int j = 0; j < 3; j++) {
                for(int k = 0; k < 3; k++) {
                    if(separate_base[i][j] == separate_num[k]) {
                        if(j == k) strike ++;
                        else ball ++;
                    }
                }
            }
            if(strike == separate_base[i][3] && ball == separate_base[i][4]) continue;
            else return false;
        }
        return true;
    }
}