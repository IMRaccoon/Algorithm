// 6 Score
package greedy;

public class Biggest_Number {
    public static void main(String[] args) {
        Biggest_Number BN = new Biggest_Number();
    }
    private Biggest_Number() {
        System.out.println(solution("1924", 2));
        System.out.println(solution("1231234", 3));
        System.out.println(solution("4177252841", 4));
        System.out.println(solution("10000", 2));
        System.out.println(solution("9999999999998", 2));
        System.out.println(solution("91111111111", 3));
    }
    public String solution(String number, int k) {
        int length = number.length();
        int final_length = length - k;
        if(length - k == 1) System.out.println("9");
        StringBuilder string = new StringBuilder(number);
        while(true) {
            string = repeat(string, length, final_length);
            if(string.length() == final_length) return string.toString();
        }
    }
    private static StringBuilder repeat(StringBuilder string, int length, int final_length) {
        for(int j = 0 ; j <length-1; j++) {
            if(string.charAt(j) < string.charAt(j+1)) {
                string.deleteCharAt(j);
                return string;
            }
        }
        return string.delete(final_length, length);
    }
}
