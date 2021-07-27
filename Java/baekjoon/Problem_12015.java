import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        ArrayList<Integer> acc = new ArrayList<>();
        acc.add(0);
        for (int i = 0; i < N; i++) {
            if (acc.get(acc.size() - 1) < arr[i]) {
                acc.add(arr[i]);
            } else {
                int start = 0, end = acc.size() - 1;
                while (start < end) {
                    int mid = (start + end) / 2;
                    if (arr[i] > acc.get(mid)) {
                        start = mid + 1;
                    } else {
                        end = mid;
                    }
                }
                acc.set(end, arr[i]);
            }
        }
        System.out.println(acc.size() - 1);
    }
}
