import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1967 {
    static int [] distance;
    static ArrayList<Node> [] link;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(0);
            return;
        }
        link = new ArrayList[N];
        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken()) - 1;
            int child = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            if (link[parent] == null) {
                link[parent] = new ArrayList<>();
            }
            if (link[child] == null) {
                link[child] = new ArrayList<>();
            }
            link[parent].add(new Node(child, distance));
            link[child].add(new Node(parent, distance));
        }

        int longestIndex = findLongest(0);
        int result = findLongest(longestIndex);
        System.out.println(distance[result]);
    }

    private static int findLongest(int start) {
        distance = new int[N];
        Arrays.fill(distance, -1);
        distance[start] = 0;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (Node n : link[cur]) {
                if (distance[n.idx] == -1) {
                    distance[n.idx] = distance[cur] + n.dist;
                    q.offer(n.idx);
                }
            }
        }
        int max = 0;
        int maxIndex = -1;
        for (int i = 0; i < N; i++) {
            if (max < distance[i]) {
                max = distance[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    private static class Node {
        int dist;
        int idx;

        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
    }
}
