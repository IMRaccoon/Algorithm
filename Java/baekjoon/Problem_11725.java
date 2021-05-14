import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [] map = new int[n + 1];

        ArrayList<Integer>[] array = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
        }
        map[1] = 1;
        for(int i = 0 ; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());

            array[a].add(b);
            array[b].add(a);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()) {
            int target = q.poll();
            for(int t: array[target]) {
                if(map[t] == 0) {
                    map[t] = target;
                    q.add(t);
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            bw.append(map[i] + "\n");
        }
        bw.flush();
    }
}
