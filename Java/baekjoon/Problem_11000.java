import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_11000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Class [] classes = new Class[n];

        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            classes[i] = new Class(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(classes);

        PriorityQueue<Integer> status = new PriorityQueue<>();
        status.add(0);
        for(Class c : classes) {
            int curEnd = status.peek();
            if(curEnd <= c.start) {
                status.poll();
            }
            status.add(c.end);
        }

        System.out.println(status.size());
    }

    private static class Class implements Comparable<Class> {
        int start;
        int end;
        int duration;

        Class(int start, int end) {
            this.start = start;
            this.end = end;
            duration = end - start;
        }

        @Override
        public int compareTo(Class aClass) {
            if(this.start == aClass.start) {
                return this.end - aClass.end;
            }
            return this.start - aClass.start;
        }
    }
}
