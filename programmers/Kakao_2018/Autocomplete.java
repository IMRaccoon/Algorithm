// 4 Score
package Kakao_2018;
import java.util.Arrays;

public class Autocomplete {
    public static void main(String[] args) {
        Autocomplete AC = new Autocomplete();
    }

    private Autocomplete() {
        System.out.println(solution2(new String[]{"gone", "go", "guild"}));
        System.out.println(solution(new String[]{"abc", "def", "ghi", "jklm"}));
        System.out.println(solution(new String[]{"word", "war", "warrior", "world"}));
    }
    public int solution(String[] words) {
        int answer = 0;
        int count, existCount = 0;
        int bigger = 0;
        Arrays.sort(words);
        for(int i = 0; i<words.length; i++) {
            count = 0;
            if(i != words.length-1) {
                try {
                    while (words[i].charAt(count) == words[i + 1].charAt(count)) { count++; }
                }catch (StringIndexOutOfBoundsException e) { }
            }
            bigger = count > existCount ? count : existCount;
            if(words[i].length() != bigger) bigger++;
            answer += bigger;
            existCount = count;
        }
        return answer;
    }

    public int solution2(String[] words) {          // Runtime Error
        int answer = 0;
        Trie trie = new Trie();
        Arrays.sort(words);
        for(String a:words)
            trie.addWord(a);
        for(String a :words)
            answer += trie.checkWord(a);
        return answer;
    }
    class Trie {
        private Node root;
        Trie() { root = new Node(); }
        public void addWord(String word) { root.addWord(word); }
        public int checkWord(String word) { return root.checkWord(word); }
    }
    class Node {
        private Node[] children;
        private boolean isFirst;

        Node() {
            isFirst = true;
            children = new Node[26];
        }

        protected void addWord(String word) {
            int charPos = word.charAt(0) - 'a';
            if(children[charPos] == null) {
                children[charPos] = new Node();
            } else children[charPos].isFirst = false;
            if(word.length() > 1) {
                children[charPos].addWord(word.substring(1));
            }
        }
        protected int checkWord(String word) {
            int charPos = word.charAt(0) - 'a';
            if(!children[charPos].isFirst && word.length() > 1) {
                return children[charPos].checkWord(word.substring(1)) + 1;
            }
            else return 1;
        }
    }
}