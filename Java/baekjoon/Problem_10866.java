import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Problem_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            String cmd = st.nextToken();

            if(cmd.equals("push_front")){
                q.addFirst(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("push_back")) {
                q.addLast(Integer.parseInt(st.nextToken()));
            } else if(cmd.equals("pop_front")) {
                if(q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.poll() + "\n");
                }
            } else if(cmd.equals("pop_back")) {
                if(q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.pollLast() + "\n");
                }
            } else if(cmd.equals("size")) {
                bw.write(q.size() + "\n");
            } else if(cmd.equals("empty")) {
                if(q.isEmpty()) {
                    bw.write("1\n");
                } else {
                    bw.write("0\n");
                }
            } else if(cmd.equals("front")) {
                if(q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.getFirst() + "\n");
                }
            } else if(cmd.equals("back")) {
                if(q.isEmpty()) {
                    bw.write("-1\n");
                } else {
                    bw.write(q.getLast() + "\n");
                }
            }
        }
        bw.flush();
    }
}
