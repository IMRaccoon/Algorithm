import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_2568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();
        HashMap<Integer, Integer> dp = new HashMap<>();
        int l, r;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            left.put(l, r);
            right.put(r, l);
        }

        ArrayList<Integer> acc = new ArrayList<>();
        int max = 0;

        // key 왼쪽, cur 오른쪽
        for(int key : left.keySet().stream().sorted(Comparator.naturalOrder()).toArray(Integer[]::new)) {
            int cur = left.get(key);
            if (acc.isEmpty() || acc.get(acc.size() - 1) < cur) {
                acc.add(cur);
                dp.put(cur, acc.size() - 1);
            } else {
                int a = 0, b = acc.size() - 1, m;
                while(a < b) {
                    m = (a + b) / 2;
                    if(cur > acc.get(m)) a = m + 1;
                    else b = m;
                }
                acc.set(b, cur);
                dp.put(cur, b);
            }
            max = Math.max(max, dp.get(cur));
        }
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> answer = new LinkedList<>();

        for(int key : dp.keySet().stream().sorted(Comparator.reverseOrder()).toArray(Integer[]::new)) {
            if (max == dp.get(key)) max -= 1;
            else answer.add(right.get(key));
        }
        answer.sort(Comparator.naturalOrder());

        sb.append(answer.size()).append("\n");
        for(int ans : answer) {
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
