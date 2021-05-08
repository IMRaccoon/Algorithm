// 2 Score
package hash;

import java.util.Arrays;

public class Player_Didnt_Finish {
    public static void main(String[] args) {
        Player_Didnt_Finish PDF = new Player_Didnt_Finish();
    }
    private Player_Didnt_Finish() {
        System.out.println(solution(new String[]{"leo", "kiki", "eden" }, new String[]{"eden", "kiki" }));
        System.out.println(solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa" }, new String[]{"josipa", "filipa", "marina", "nikola" }));
        System.out.println(solution(new String[]{"mislav", "stanko", "mislav", "ana" }, new String[]{"stanko", "ana", "mislav" }));
    }
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        int length = completion.length;
        for(int i = 0 ; i< length; i++) {
            if(!participant[i].equals(completion[i]))
                return participant[i];
        }
        return participant[length];
    }
}
