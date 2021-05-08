// 1 Score
package summer_winter_coding_2018;

import java.util.ArrayList;


public class Skill_Tree {
    public static void main(String[] args) {
        System.out.println(solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));

    }
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        ArrayList<Character> array = new ArrayList<>(){};
        for(char a : skill.toCharArray()) {
            array.add(a);
        }
        for (String s : skill_trees) {
            StringBuilder sb = new StringBuilder(s);
            int length = sb.length();
            int counter = 0;
            boolean isAnswer = true;
            for (int i = 0; i < length; i++) {
                int index = array.indexOf(sb.charAt(i));
                if (index != -1) {
                    if (counter == index) {
                        counter += 1;
                    }
                    else {
                        isAnswer = false;
                        break;
                    }
                }
            }
            if(isAnswer) {
                answer += 1;
            }
        }
        return answer;
    }
}
