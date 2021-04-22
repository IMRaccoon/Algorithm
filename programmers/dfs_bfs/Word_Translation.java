package dfs_bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Word_Translation {
    public static void main(String[] args) {
        Word_Translation tmp = new Word_Translation();
        String begin = "hit";
        String target = "cog";

        String[][] words = new String[][] {{"hot", "dot", "dog", "lot", "log", "cog"}, {"hot", "dot", "dog", "lot", "log"}};

        System.out.println(tmp.solution(begin, target, words[0]));
        System.out.println(tmp.solution(begin, target, words[1]));

    }

    public int solution(String begin, String target , String[] words) {
        boolean hasTarget = false;
        for(String word : words) {
            if(word.equals(target)) {
                hasTarget = true;
                break;
            }
        }
        if(!hasTarget) {
            return 0;
        }

        List<String> listedWords = new LinkedList<>(Arrays.asList(words));

        int answer =  dfs(listedWords, begin, target);
        if(answer >= 51) {
            return 0;
        }
        return answer;
    }

    public int dfs(List<String> words, String cur, String target) {
        if(words.size() == 0) {
            return 51;
        }

        int max = 51;
        for(String word: words) {
            if(isSameOneChar(cur, word)) {
                if(word.equals(target)) {
                    return 1;
                }
                List<String> copy = new LinkedList<>(List.copyOf(words));
                copy.remove(word);
                max = Math.min(max, 1 + dfs(copy, word, target));
            }
        }

        return max;
    }

    public boolean isSameOneChar(String compareA, String compareB) {
        char [] arrayA = compareA.toCharArray();
        char [] arrayB = compareB.toCharArray();

        boolean check = false;
        for(int i = 0 ; i < arrayA.length; i++) {
            if(arrayA[i] != arrayB[i]) {
                if (!check) {
                    check = true;
                }
                else {
                    return false;
                }
            }
        }
        return check;
    }
}
