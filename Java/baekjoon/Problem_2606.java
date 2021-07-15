import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_2606 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        StringTokenizer st;

        ArrayList<Integer>[] arr = new ArrayList[n + 1];
        int first, second;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            if (arr[first] == null) {
                arr[first] = new ArrayList<>();
            }
            if (arr[second] == null) {
                arr[second] = new ArrayList<>();
            }
            arr[first].add(second);
            arr[second].add(first);
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        int count = 0;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        q.offer(1);

        int cur;
        while (!q.isEmpty()) {
            cur = q.poll();
            for (int a : arr[cur]) {
                if (!visited[a]) {
                    count += 1;
                    visited[a] = true;
                    q.offer(a);
                }
            }
        }
        System.out.println(count);
    }
}
