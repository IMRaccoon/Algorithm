package Kakao_2020;

public class Compress_String {
    public static void main(String[] args) {
        Compress_String CS = new Compress_String();
    }
    private Compress_String() {
        System.out.println(solution("aabbaccc"));
        System.out.println(solution("ababcdcdababcdcd"));
        System.out.println(solution("abcabcdede"));
        System.out.println(solution("abcabcabcabcdededededede"));
        System.out.println(solution("xababcdcdababcdcd"));
    }
    public int solution(String s) {
        int length = s.length();
        int answer = length;
        for(int i = 1; i <= Math.floorDiv(length+1, 2); i++) {
            String token = s.substring(0, i);
            int tmp_answer = length;
            int duplicated = 0;
            for(int j = 1; j < Math.floorDiv(length, i); j++) {
                String tmpToken = s.substring(j*i, (j+1) * i);
                // System.out.println("tmpToken : " + tmpToken);
                if(!token.equals(tmpToken)){
                    token = tmpToken;
                    if(duplicated != 0) {
                        tmp_answer += Integer.toString(duplicated).length();
                        duplicated = 0;
                    }
                }
                else {
                    if(duplicated == 0) {
                        duplicated = 2;
                    }
                    else {
                        duplicated += 1;
                    }
                    tmp_answer -= i;
                }
            }
            if(duplicated != 0) {
                tmp_answer += Integer.toString(duplicated).length();
            }
            answer = answer > tmp_answer ? tmp_answer : answer;
        }
        return answer;
    }
}
