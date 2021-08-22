package Kakao_2021;

public class Number_String_Word {
    public static void main(String[] args) {
        Number_String_Word nsw = new Number_String_Word();
        System.out.println(nsw.solution("one4seveneight"));
        System.out.println(nsw.solution("23four5six7"));
    }

    public int solution(String s) {
        s = s.replaceAll("zero", "0");
        s = s.replaceAll("one", "1");
        s = s.replaceAll("two", "2");
        s = s.replaceAll("three", "3");
        s = s.replaceAll("four", "4");
        s = s.replaceAll("five", "5");
        s = s.replaceAll("six", "6");
        s = s.replaceAll("seven", "7");
        s = s.replaceAll("eight", "8");
        s = s.replaceAll("nine", "9");
        return Integer.parseInt(s);
    }
}
