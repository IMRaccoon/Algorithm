// 5 Score
package sort;

import java.util.Arrays;

public class Biggest_Number {
    public static void main(String[] args) {
        Biggest_Number BN = new Biggest_Number();
    }
    private Biggest_Number() {
        System.out.println(solution(new int[]{6, 10, 2}));
        System.out.println(solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution(new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19}));
        System.out.println(solution(new int[]{0,0,0,0,0,0,0,10000}));
        System.out.println(solution(new int[]{40,403}));
        System.out.println(solution(new int[]{40,404}));
        System.out.println(solution(new int[]{40,405}));
        System.out.println(solution(new int[] {12,121}));
        System.out.println(solution(new int[] {2,22,223}));
        System.out.println(solution(new int[] {21,212}));
        System.out.println(solution(new int[] {41,415}));
        System.out.println(solution(new int[] {12,1213}));
    }
    public String solution(int [] number) {
        Integer[] sort = new Integer[number.length];
        for(int i = 0 ; i < number.length; i++)
            sort[i] = number[i];
        Arrays.sort(sort, (o1, o2) -> (o2.toString() + o1.toString()).compareTo(o1.toString() + o2.toString()));
        String answer = "";
        for(Integer a : sort)
            answer += String.valueOf(a);
        if(answer.charAt(0) == '0') return "0";
        return answer;
    }
}