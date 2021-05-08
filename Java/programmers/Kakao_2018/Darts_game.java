// 2 Score
package Kakao_2018;

public class Darts_game {
    public static void main(String[] args) {
        Darts_game dg = new Darts_game();
    }
    private Darts_game() {
        System.out.println(solution("1S2D*3T"));
        System.out.println(solution("1D2S#10S"));
        System.out.println(solution("1D2S0T"));
        System.out.println(solution("10S2D#3S"));
        System.out.println(solution("1D#2S*3S"));
        System.out.println(solution("1T2D3D#"));
        System.out.println(solution("1D2S3T*"));
    }
    public int solution(String dartResult) {
        String [] data= new String[3];
        int flag = 0, flag2 = 0;
        int [] answer = new int[3];
        dartResult += "1";
        for(int i = 2; i<dartResult.length(); i++) {
            if(Character.isDigit(dartResult.charAt(i))) {
                data[flag] = dartResult.substring(flag2, i);
                flag ++;
                flag2 = i;
                i++;
            }
        }
        for(int i = 0 ; i < 3; i++) {
            flag = 1;
            answer[i] = data[i].charAt(0) - 48;
            if(data[i].charAt(flag) == 48) {
                flag++;
                answer[i] = 10;
            }
            if(data[i].charAt(flag) == 68) {          // Double
                answer[i] = (int)Math.pow(answer[i], 2);
            }
            else if(data[i].charAt(flag) == 84) {      // Triple
                answer[i] = (int)Math.pow(answer[i], 3);
            }
            flag ++;
            if(data[i].length() != flag) {
                if(data[i].charAt(flag) == 35)          // #
                    answer[i] = -answer[i];
                else if(data[i].charAt(flag) == 42){                                  // *
                    answer[i] *= 2;
                    if(i > 0) {
                        answer[i-1] *= 2;
                    }
                }
            }
        }
        return answer[0] + answer[1] + answer[2];
    }
}
