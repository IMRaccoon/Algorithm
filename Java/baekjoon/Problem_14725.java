import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Problem_14725 {
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        TrieNode trie = new TrieNode();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            TrieNode cur = trie;

            for (int j = 0; j < K; j++) {
                cur = cur.addIfAbsent(st.nextToken());
                cur.depth = j;
            }
            cur.isLast = true;
        }
        dfs(trie);
        System.out.println(sb.toString());
    }

    private static void dfs(TrieNode cur) {
        if (cur.isLast) return;

        for (Map.Entry<String, TrieNode> entry : cur.children.entrySet()) {
            for (int i = 0; i < entry.getValue().depth; i++) {
                sb.append("--");
            }
            sb.append(entry.getKey()).append("\n");
            dfs(entry.getValue());
        }
    }

    private static class TrieNode {
        TreeMap<String, TrieNode> children;
        int depth;
        boolean isLast;

        TrieNode() {
            children = new TreeMap<>();
            isLast = false;
            depth = -1;
        }

        public TrieNode addIfAbsent(String input) {
            if (!children.containsKey(input)) {
                children.put(input, new TrieNode());
            }
            return children.get(input);
        }
    }
}
