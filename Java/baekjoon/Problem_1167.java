import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_1167 {
    static LinkedList<Node>[] distances;
    static boolean[] visited;
    static int furthest = 0;
    static int distance = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        distances = new LinkedList[V + 1];

        for (int i = 1; i <= V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            distances[start] = new LinkedList<>();

            int end;
            while ((end = Integer.parseInt(st.nextToken())) != -1) {
                distances[start].add(new Node(end, Integer.parseInt(st.nextToken())));
            }
        }
        visited = new boolean[V + 1];
        visited[1] = true;
        findFurthest(1, 0);

        visited = new boolean[V + 1];
        visited[furthest] = true;
        findFurthest(furthest, 0);
        System.out.println(distance);
    }

    private static void findFurthest(int start, int acc) {
        if(distance < acc) {
            furthest = start;
            distance = acc;
        }
        for (Node cur : distances[start]) {
            if (visited[cur.end]) continue;
            visited[cur.end] = true;
            findFurthest(cur.end, acc + cur.distance);
        }
    }

    private static class Node {
        int end;
        int distance;

        Node(int end, int distance) {
            this.end = end;
            this.distance = distance;
        }
    }
}
