import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());

        while (T-- != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            String [] map = new String[10000];
            ArrayDeque<Integer> q = new ArrayDeque<>();
            map[a] = "";
            q.offer(a);

            while (!q.isEmpty()) {
                int num = q.poll();
                String cur = map[num];
                if (num == b) {
                    bw.write(cur + "\n");
                    break;
                }

                int copy = (num * 2) % 10000;
                if (map[copy] == null) {
                    map[copy] = cur + "D";
                    q.offer(copy);
                }

                copy = num == 0 ? 9999 : num - 1;
                if (map[copy] == null) {
                    map[copy] = cur + "S";
                    q.offer(copy);
                }

                copy = (num % 1000) * 10 + (num / 1000);
                if (map[copy] == null) {
                    map[copy] = cur + "L";
                    q.offer(copy);
                }

                copy = (num - ((num / 10) * 10)) * 1000 + (num / 10);
                if (map[copy] == null) {
                    map[copy] = cur + "R";
                    q.offer(copy);
                }
            }
        }
        bw.flush();
    }
}
