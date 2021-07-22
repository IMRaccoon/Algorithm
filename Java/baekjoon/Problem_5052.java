import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Problem_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Trie trie;
        int T = Integer.parseInt(br.readLine()), N;
        boolean isNo;
        String input;

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            trie = new Trie();
            isNo = false;

            for (int i = 0; i < N; i++) {
                input = br.readLine();
                if (!isNo && !trie.insert(input)) {
                    isNo = true;
                }
            }

            bw.write(isNo ? "NO" : "YES");
            bw.newLine();
        }
        bw.flush();
    }

    private static class TrieNode {
        private Map<Character, TrieNode> childNode;
        private boolean isLastChar;

        TrieNode() {
            childNode = new HashMap<>();
            isLastChar = false;
        }
        TrieNode(boolean isLastChar) {
            this.isLastChar = isLastChar;
        }

        boolean isLast() {
            return this.isLastChar;
        }

        Map<Character, TrieNode> getChildNode() {
            return this.childNode;
        }
    }

    private static class Trie {
        private TrieNode rootNode;

        Trie() {
            rootNode = new TrieNode();
        }

        boolean insert(String input) {
            char [] arr = input.toCharArray();
            TrieNode cur = rootNode;
            TrieNode tmp;
            for(int i = 0 ; i < arr.length - 1; i++) {
                if(cur.getChildNode().get(arr[i]) == null) {
                    tmp = new TrieNode();
                    cur.getChildNode().put(arr[i], tmp);
                    cur = tmp;
                } else {
                    cur = cur.getChildNode().get(arr[i]);
                    if(cur.isLast()) return false;
                }
            }
            if(cur.getChildNode().containsKey(arr[arr.length - 1])) {
                return false;
            }
            cur.getChildNode().put(arr[arr.length - 1], new TrieNode(true));
            return true;
        }
    }
}
