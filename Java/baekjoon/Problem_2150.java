import java.io.*;
import java.util.*;

public class Problem_2150 {
    static ArrayList<Integer>[] route;
    static int[] group;
    static int[] discover;
    static Stack<Integer> stack;
    static int discoverIndex;
    static int groupIndex;
    static ArrayList<ArrayList<Integer>> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()), E = Integer.parseInt(st.nextToken());
        group = new int[V + 1];
        discover = new int[V + 1];
        route = new ArrayList[V + 1];
        discoverIndex = 0;
        groupIndex = 0;
        answer = new ArrayList<>();

        for (int i = 1; i <= V; i++) {
            route[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken());
            route[start].add(end);
        }
        stack = new Stack<>();

        for (int i = 1; i <= V; i++) {
            if (group[i] == 0) dfs(i);
        }
        bw.write(groupIndex + "\n");
        answer.sort(Comparator.comparingInt(t -> t.get(0)));
        for (ArrayList<Integer> ans : answer) {
            for (int a : ans) {
                bw.write(a + " ");
            }
            bw.write("-1\n");
        }
        bw.flush();
    }

    private static int dfs(int start) {
        discover[start] = ++discoverIndex;
        int res = discoverIndex;
        stack.push(start);
        for (int next : route[start]) {
            if (discover[next] == 0) {
                // 방문한 적 없으면
                res = Math.min(res, dfs(next));
            } else if (group[next] == 0) {
                // 방문한 적 있는데 Group 지정이 안되었을 경우
                res = Math.min(res, discover[next]);
            }
        }
        if (res == discover[start]) {
            // 바뀌지 않았으면 == 루프가 생기는 가장 처음 부분, 또는 다음 점이 없는 상태에서 루프가 없는 경우
            ArrayList<Integer> tmp = new ArrayList<>();
            groupIndex += 1;
            while (true) {
                int pop = stack.pop();
                tmp.add(pop);
                group[pop] = groupIndex;
                if (pop == start) break;
            }
            tmp.sort(Comparator.naturalOrder());
            answer.add(tmp);
        }
        return res;
    }
}
