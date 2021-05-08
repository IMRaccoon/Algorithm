// 1 Score
package Kakao_2018;
import java.util.Arrays;

public class Secret_Map {
    public static void main(String[] args) {
        Secret_Map sm = new Secret_Map();
    }
    private Secret_Map() {
        System.out.println(Arrays.toString(solution(5, new int[]{9, 20, 28, 18, 11}, new int[]{30, 1, 21, 17, 28})));
        System.out.println(Arrays.toString(solution(6, new int[]{46, 33, 33, 22, 31, 50}, new int[]{27, 56, 19, 14, 14, 10})));
    }
    public String [] solution(int n, int [] arr1, int [] arr2) {
        String[] answer = new String[n];
        String flag;
        for(int i = 0 ; i < n; i++) {
            flag = String.format("%"+n+"s",Integer.toBinaryString(arr1[i]|arr2[i]));
            answer[i] = "";
            for(int j = 0; j < n; j++)
                answer[i] = flag.charAt(j) == '1' ? answer[i]+'#':answer[i]+' ';
        }
        return answer;
    }
}
