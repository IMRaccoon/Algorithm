import java.io.*;
import java.util.*;

public class Problem_1005 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());

            LinkedList<Integer>[] preCondition = new LinkedList[n];
            int [] durations = new int[n];
            int[] times = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                preCondition[j] = new LinkedList<>();
                durations[j] = Integer.parseInt(st.nextToken());
                times[j] = -1;
            }

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int pre = Integer.parseInt(st.nextToken()) - 1, post = Integer.parseInt(st.nextToken()) - 1;
                preCondition[post].add(pre);
            }

            int target = Integer.parseInt(br.readLine()) - 1;

            Queue<Integer> q = new ArrayDeque<>();
            q.add(target);
            times[target] = durations[target];

            Set<Integer> answerList = new TreeSet<>();
            while (!q.isEmpty()) {
                int curIndex = q.poll();

                if (!preCondition[curIndex].isEmpty()) {
                    for (int pre : preCondition[curIndex]) {
                        if(times[pre] < times[curIndex] + durations[pre]) {
                            times[pre] = times[curIndex] + durations[pre];
                            q.add(pre);
                        }
                    }
                } else {
                    answerList.add(curIndex);
                }
            }

            int answer = Integer.MAX_VALUE;
            for (int index : answerList) {
                answer = Math.min(times[index], answer);
            }
            bw.write(answer + "\n");
        }
        bw.flush();
    }
}
