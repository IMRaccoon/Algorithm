import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1766 {
    static ArrayList<Integer>[] children;
    static int[] visited, parents;
    static ArrayList<ArrayList<Integer>> answers;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        parents = new int[N + 1];
        children = new ArrayList[N + 1];
        visited = new int[N + 1];
        Arrays.fill(visited, -1);

        for (int i = 1; i <= N; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken()), second = Integer.parseInt(st.nextToken());
            parents[second] += 1;
            children[first].add(second);
        }
        for (int i = 1; i <= N; i++) {
            if (!children[i].isEmpty()) children[i].sort(Comparator.naturalOrder());
        }

        answers = new ArrayList<>();
        queue = new PriorityQueue<>();
        int index = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] == 0 && visited[i] == -1) {
                visited[i] = index++;
                answers.add(new ArrayList<>());
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            answers.get(visited[cur]).add(cur);
            for (Integer child : children[cur]) {
                parents[child] -= 1;
                if (parents[child] == 0) {
                    queue.add(child);
                    visited[child] = Math.max(visited[child], visited[cur]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (ArrayList<Integer> ans : answers) {
            for (int a : ans) {
                sb.append(a).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

}