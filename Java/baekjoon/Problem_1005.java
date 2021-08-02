import java.io.*;
import java.util.*;

public class Problem_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        while (t-- != 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
            int[] times = new int[N + 1];
            int[] acc = new int[N + 1];

            int[] parents = new int[N + 1];
            ArrayList<Integer>[] children = new ArrayList[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                parents[c] += 1;
                if (children[p] == null) children[p] = new ArrayList<>();
                children[p].add(c);
            }
            int W = Integer.parseInt(br.readLine());
            if (parents[W] == 0) {
                bw.write(times[W] + "\n");
                continue;
            }
            ArrayDeque<Integer> q = new ArrayDeque<>();
            for (int i = 1; i <= N; i++) {
                if (parents[i] == 0) {
                    q.offer(i);
                    acc[i] = times[i];
                }
            }

            while (!q.isEmpty()) {
                int cur = q.poll();
                for (int c : children[cur]) {
                    parents[c] -= 1;
                    if (parents[c] == 0 && children[c] != null && c != W) q.offer(c);
                    if (acc[c] >= acc[cur] + times[c]) continue;
                    acc[c] = acc[cur] + times[c];
                }
            }
            bw.write(acc[W] + "\n");
        }
        bw.flush();
    }
}
