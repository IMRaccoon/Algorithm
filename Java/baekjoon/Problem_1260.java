import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_1260 {
    static Graph[] g;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken()), v = Integer.parseInt(st.nextToken());
        g = new Graph[n + 1];

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (g[a] == null) {
                g[a] = new Graph();
            }
            g[a].addPoint(b);

            if (g[b] == null) {
                g[b] = new Graph();
            }
            g[b].addPoint(a);
        }

        if(g[v] == null) {
            bw.write(v + "\n" + v);
            bw.flush();
            return;
        }

        for(int i = 1; i <= n ; i++ ){
            if(g[i] != null) {
                g[i].arr.sort(Comparator.comparingInt(v2 -> v2));
            }
        }

        g[v].visited = true;
        bw.write(dfs(v) + "\n");

        for (int i = 1; i <= n; i++) {
            if(g[i] != null) {
                g[i].visited = false;
            }
        }
        g[v].visited = true;
        bw.write(bfs(v));
        bw.flush();
    }

    private static String dfs(int point) {
        StringBuilder sb = new StringBuilder(String.valueOf(point));
        for (int a : g[point].arr) {
            if (!g[a].visited) {
                g[a].visited = true;
                sb.append(" ").append(dfs(a));
            }
        }
        return sb.toString();
    }

    private static String bfs(int point) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(point);
        StringBuilder sb = new StringBuilder(String.valueOf(point));
        int tmp;

        while (!q.isEmpty()) {
            tmp = q.poll();
            for (int a : g[tmp].arr) {
                if(!g[a].visited) {
                    g[a].visited = true;
                    sb.append(" ").append(a);
                    q.offer(a);
                }
            }
        }
        return sb.toString();
    }

    private static class Graph {
        ArrayList<Integer> arr;
        boolean visited;

        Graph() {
            visited = false;
            arr = new ArrayList<>();
        }

        void addPoint(int p) {
            arr.add(p);
        }
    }
}

