import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_17616 {
    static int n, m, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] upper = new ArrayList[n + 1];
        ArrayList<Integer>[] downer = new ArrayList[n + 1];


        int win, lose;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            win = Integer.parseInt(st.nextToken());
            lose = Integer.parseInt(st.nextToken());

            if (upper[lose] == null) {
                upper[lose] = new ArrayList<>();
            }
            if (downer[win] == null) {
                downer[win] = new ArrayList<>();
            }
            upper[lose].add(win);
            downer[win].add(lose);
        }
        System.out.println(getCount(upper) + " " + (n - getCount(downer) + 1));
    }

    private static int getCount(ArrayList<Integer>[] target) {
        int upperCount = 1;
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(x);
        visited[x] = true;
        int cur;

        while (!q.isEmpty()) {
            cur = q.poll();
            if (target[cur] == null) {
                continue;
            }
            for (int p : target[cur]) {
                if (!visited[p]) {
                    visited[p] = true;
                    upperCount += 1;
                    q.offer(p);
                }
            }
        }
        return upperCount;
    }
}
