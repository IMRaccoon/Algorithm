// 1 Score
package Kakao_2018;

import java.util.ArrayList;
import java.util.Arrays;

public class Zip {
    public static void main(String[] args) {
        Zip zip = new Zip();
    }
    private Zip() {
        //System.out.println(Arrays.toString(solution("KAKAO")));
        //System.out.println(Arrays.toString(solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(solution("ABABABABABABABAB")));
    }
    public int [] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        String flag = "";
        int mapLength = 26;
        ArrayList<String> list = new ArrayList<>();
        for(int i = 1 ; i <= mapLength; i++)
            list.add(String.valueOf((char)(64+i)));
        for(int i = 0 ; i < msg.length(); i++) {
            flag += msg.charAt(i);
            if(i+2 > msg.length()) {
                answer.add(list.indexOf(flag));
            }
            else if(!list.contains(flag + msg.charAt(i+1))) {
                answer.add(list.indexOf(flag));
                list.add(flag + msg.charAt(i+1));
                mapLength ++;
                flag = "";
            }
        }
        int [] a = new int[answer.size()];
        for(int i = 0 ; i < answer.size(); i++)
            a[i] = answer.get(i) + 1;
        return a;
    }
}
