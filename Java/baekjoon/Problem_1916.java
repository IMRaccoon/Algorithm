import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cityNum = Integer.parseInt(br.readLine());
        int busNum = Integer.parseInt(br.readLine());

        ArrayList<Dest> [] routes = new ArrayList[cityNum];
        long [] visited = new long[cityNum];
        for(int i = 0 ; i < cityNum; i++) {
            visited[i] = Long.MAX_VALUE;
            routes[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < busNum; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int price = Integer.parseInt(st.nextToken());

            routes[start].add(new Dest(end, price));
        }
        for(int i = 0 ; i < cityNum; i++) {
            routes[i].sort(Comparator.comparingInt(dest -> dest.price));
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1, end = Integer.parseInt(st.nextToken()) - 1;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(start);
        visited[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();
            if(visited[end] < visited[cur] || cur == end) {
                continue;
            }

            for(Dest d : routes[cur]) {
                if(d.price + visited[cur] < visited[d.end]) {
                    visited[d.end] = d.price + visited[cur];
                    q.offer(d.end);
                }
            }
        }
        System.out.println(visited[end]);
    }
    private static class Dest {
        int end;
        int price;

        Dest(int end, int price) {
            this.end = end;
            this.price = price;
        }
    }
}
