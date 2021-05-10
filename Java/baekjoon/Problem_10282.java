import java.io.*;
        import java.util.*;

public class Problem_10282 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());
        ArrayList<Pair>[] dependency = new ArrayList[10001];
        int[] visited = new int[10001];
        ArrayDeque<Dest> q;

        for(int i = 0 ; i < test; i++) {
            st = new StringTokenizer(br.readLine());

            int computerNum = Integer.parseInt(st.nextToken());
            int dependNum = Integer.parseInt(st.nextToken());
            int hackStart = Integer.parseInt(st.nextToken());
            int child, parent, time;

            for(int j = 1; j <= computerNum; j++) {
                dependency[j] = new ArrayList<>();
                visited[j] = Integer.MAX_VALUE;
            }

            for(int j = 0 ; j < dependNum; j++) {
                st = new StringTokenizer(br.readLine());
                child = Integer.parseInt(st.nextToken());
                parent = Integer.parseInt(st.nextToken());
                time = Integer.parseInt(st.nextToken());

                dependency[parent].add(new Pair(child, time));
            }

            q = new ArrayDeque<>();
            q.add(new Dest(hackStart, 0));
            visited[hackStart] = 0;


            while(!q.isEmpty()) {
                Dest cur = q.poll();

                for (Pair dest : dependency[cur.next]) {
                    if (dest.price + cur.acc >= visited[dest.child]) {
                        continue;
                    }
                    visited[dest.child] = dest.price + cur.acc;
                    q.add(new Dest(dest.child, visited[dest.child]));
                }
            }

            int count = 0;
            int max = 0;

            for(int j = 1; j <= computerNum; j++) {
                if(visited[j] < Integer.MAX_VALUE) {
                    count ++;
                    max = Math.max(visited[j], max);
                }
            }
            bw.write(count + " " + max + "\n");
        }

        bw.flush();
    }

    private static class Pair  {
        int child;
        int price;

        Pair(int child, int price){
            this.child = child;
            this.price = price;
        }
    }

    private static class Dest implements Comparable<Dest> {
        int next;
        int acc;

        Dest(int next, int acc) {
            this.next = next;
            this.acc = acc;
        }

        @Override
        public int compareTo(Dest dest) {
            return this.acc - dest.acc;
        }
    }
}
