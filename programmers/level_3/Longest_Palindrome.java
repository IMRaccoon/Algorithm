// 6 Score
package level_3;

public class Longest_Palindrome {
    public static void main(String[] args) {
        Longest_Palindrome LP = new Longest_Palindrome();
    }
    private Longest_Palindrome() {
        System.out.println(solution("abccccba"));
        System.out.println(solution("abacde"));
    }
    public int solution(String s) {
        int answer = 1;
        int compare;
        char [] ch = s.toCharArray();
        int length = s.length();
        for(int i = 1; i<length-1; i++) {
            if(ch[i-1] == ch[i+1]) {
                compare = 3;
                int j = 2;
                try {
                    while(ch[i+j] == ch[i-j]) {
                        compare += 2;
                        j++;
                    }
                }catch(ArrayIndexOutOfBoundsException e) { }
                answer = answer > compare ? answer : compare;
            }
            if(ch[i-1] == ch[i]) {
                compare = 2;
                int j = 1;
                try {
                    while(ch[i-(j+1)] == ch[i+j]) {
                        compare += 2;
                        j++;
                    }
                }catch(ArrayIndexOutOfBoundsException e) {}
                answer = answer > compare ? answer : compare;
            }
        }
        return answer;
    }
}