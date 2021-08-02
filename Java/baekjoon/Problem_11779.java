import java.io.*;
import java.util.*;

public class Problem_11779 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int PRICE_MAX = 100_000_001, BUS_MAX = 100_001;
        int N = Integer.parseInt(br.readLine()), M = Integer.parseInt(br.readLine());
        int S, E, P;
        StringTokenizer st;
        HashMap<Integer, Integer>[] bus = new HashMap[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            if(bus[S] == null) bus[S] = new HashMap<>();
            bus[S].put(E, Math.min(bus[S].getOrDefault(E, BUS_MAX), P));
        }
        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        if(S == E) {
            bw.write("0\n2\n" + S + " " + E);
            bw.flush();
            return;
        }
        PriorityQueue<Move> q = new PriorityQueue<>();
        q.offer(new Move(S, 0));

        int[] visited = new int[N + 1];
        Arrays.fill(visited, PRICE_MAX);
        visited[S] = 0;
        int [] route = new int[N + 1];

        while (!q.isEmpty()) {
            Move cur = q.poll();

            if (visited[E] < cur.price) break;
            if(bus[cur.pos] == null) continue;
            for (Map.Entry<Integer, Integer> entry : bus[cur.pos].entrySet()) {
                if (visited[entry.getKey()] > entry.getValue() + cur.price) {
                    visited[entry.getKey()] = entry.getValue() + cur.price;
                    route[entry.getKey()] = cur.pos;
                    if (entry.getKey() != E) {
                        q.offer(new Move(entry.getKey(), entry.getValue() + cur.price));
                    }
                }
            }
        }
        Stack<Integer> stack = new Stack<>();
        int start = E;
        stack.push(start);
        while(start != S) {
            start = route[start];
            stack.push(start);
        }

        bw.write(visited[E] + "\n");
        bw.write(stack.size() + "\n");
        while(!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
    }

    private static class Move implements Comparable<Move> {
        int pos;
        int price;

        Move(int pos, int price) {
            this.pos = pos;
            this.price = price;
        }

        @Override
        public int compareTo(Move move) {
            return this.price - move.price;
        }
    }
}
