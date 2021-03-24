package Kakao_2019;

import java.util.ArrayList;
import java.util.HashSet;

public class Candidate_Key {
    public static void main(String[] args) {
        Candidate_Key CK = new Candidate_Key();
    }
    private Candidate_Key() {
        System.out.println(solution(new String[][]{{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}}));
    }
    public int solution(String[][] relation) {
        ArrayList<String> answer = new ArrayList<>();
        int row = relation.length;                  // 6
        int column = relation[0].length;            // 4
        HashSet<String> hashSet = new HashSet<>();
        for(int i = 0 ; i < column; i++)
            for (String a : relation[i])
                hashSet.add(a);
            if(hashSet.size() == row) {

            }
        return answer.size();
    }
}