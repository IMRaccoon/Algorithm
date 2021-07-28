import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Problem_14003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int[] pos = new int[N];
        ArrayList<Integer> acc = new ArrayList<>();
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (acc.isEmpty() || acc.get(acc.size() - 1) < arr[i]) {
                acc.add(arr[i]);
                pos[i] = acc.size() - 1;
            } else {
                int l = 0, r = acc.size() - 1, m;
                while (l < r) {
                    m = (l + r) / 2;
                    if (acc.get(m) < arr[i]) l = m + 1;
                    else r = m;
                }
                acc.set(r, arr[i]);
                pos[i] = r;
            }
            max = Math.max(max, pos[i]);
        }

        LinkedList<Integer> answer = new LinkedList<>();
        for (int i = N - 1; i >= 0; i--) {
            if (max == pos[i]) {
                max -= 1;
                answer.addFirst(arr[i]);
            }
        }
        bw.write(answer.size() + " \n");
        for (int ans : answer) {
            bw.write(ans + " ");
        }
        bw.flush();
    }
}
