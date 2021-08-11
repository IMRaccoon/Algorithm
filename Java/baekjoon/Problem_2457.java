import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_2457 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int startM, startD, endM, endD;

        PriorityQueue<Flower> queue = new PriorityQueue<>();
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            startM = Integer.parseInt(st.nextToken());
            startD = Integer.parseInt(st.nextToken());
            endM = Integer.parseInt(st.nextToken());
            endD = Integer.parseInt(st.nextToken());
            if(endM < 3) continue;
            if(startM == 12) continue;
            queue.add(new Flower(startM, startD, endM, endD));
        }

        Flower cur = null;
        int limitM = 3, limitD = 1;
        int count = 0;

        while(!queue.isEmpty()) {
            while(!queue.isEmpty() && ((limitM > queue.peek().startM) || (limitM == queue.peek().startM && limitD >= queue.peek().startD))) {
                cur = queue.poll().compare(cur);
            }
            if(cur == null) break;
            count += 1;
            limitM = cur.endM;
            limitD = cur.endD;
            if(limitM == 12) break;
        }
        System.out.println(limitM == 12 ? count : 0);
    }

    private static class Flower implements Comparable<Flower>{
        int startM, startD, endM, endD;

        Flower(int startM, int startD, int endM, int endD) {
            this.startM = startM;
            this.startD = startD;
            this.endM = endM;
            this.endD = endD;
        }

        @Override
        public int compareTo(Flower flower) {
            if(this.startM == flower.startM) {
                if(this.startD == flower.startD) {
                    if(this.endM == flower.endM) {
                        return flower.endD - this.endD;
                    }
                    return flower.endM - this.endM;
                }
                return this.startD - flower.startD;
            }
            return this.startM - flower.startM;
        }

        public Flower compare(Object obj) {
            if(obj == null) return this;
            Flower f = (Flower) obj;
            if(f.endM == this.endM) {
                if(f.endD > this.endD) return f;
                return this;
            }
            if(f.endM > this.endM) return f;
            return this;
        }
    }
}
