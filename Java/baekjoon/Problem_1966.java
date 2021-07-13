import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ArrayDeque<Integer> q;
        ArrayList<Integer> array;
        int t = Integer.parseInt(br.readLine());
        int n, check, count, tmp, cur;

        for (int i = 0; i < t; i++) {
            q = new ArrayDeque<>();
            array = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            check = Integer.parseInt(st.nextToken());
            count = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                tmp = Integer.parseInt(st.nextToken());
                q.addLast(tmp);
                array.add(tmp);
            }

            array.sort(((t1, t2) -> t2 - t1));

            while(!array.isEmpty()) {
                cur = array.remove(0);
                while (q.peek() != cur) {
                    q.offer(q.poll());
                    check -= 1;
                }
                check = (check + q.size()) % q.size();
                count += 1;

                if (check == 0) break;
                q.poll();
                check -= 1;
            }

            System.out.println(count);
        }
    }
}
