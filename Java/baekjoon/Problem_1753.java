import java.io.*;
import java.util.*;


public class Problem_1753 {
    static int v, e;
    static List<Node>[] route;
    static int[] dest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        route = new ArrayList[v + 1];

        dest = new int[v + 1];

        for (int i = 1; i <= v; i++) {
            route[i] = new ArrayList<>();
            dest[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()), to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            route[from].add(new Node(to, w));
        }
        br.close();


        findRoute(start);
        for (int i = 1; i <= v; i++) {
            if (dest[i] == Integer.MAX_VALUE) {
                bw.write("INF\n");
            } else {
                bw.write(dest[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }

    public static void findRoute(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        boolean[] check = new boolean[v + 1];
        dest[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (check[node.to]) continue;
            check[node.to] = true;

            for(Node n : route[node.to]) {
                if(dest[n.to] > dest[node.to] + n.weight) {
                    dest[n.to] = dest[node.to] + n.weight;
                    queue.add(new Node(n.to, dest[n.to]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int to;
        int weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return weight - n.weight;
        }
    }
}
