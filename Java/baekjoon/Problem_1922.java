import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1922 {
    static int [] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        parent = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i = 0 ; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            queue.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int result = 0;
        for(int i = 0 ; i < m; i++) {
            Node cur = queue.poll();

            int parentSource = findParent(cur.source);
            int parentEnd = findParent(cur.end);

            if(parentSource == parentEnd) continue;

            parent[parentSource] = parent[parentEnd];
            result += cur.weight;
        }

        System.out.println(result);
    }

    public static int findParent(int index) {
        if(index == parent[index]) {
            return index;
        }
        return findParent(parent[index]);
    }

    static class Node implements Comparable<Node> {
        int source;
        int end;
        int weight;

        Node(int source, int end, int weight) {
            this.source = source;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }
}
