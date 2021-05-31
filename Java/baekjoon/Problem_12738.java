import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_12738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(-1_000_000_001);

        int left, right, mid;
        for(int i = 0; i < n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if(arr.get(arr.size() - 1) < cur) {
                arr.add(cur);
            } else {
                left = 0;
                right = arr.size() - 1;

                while(left < right) {
                    mid = (left + right) / 2;
                    if(arr.get(mid) < cur) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                arr.set(left, cur);
            }
        }
        System.out.println(arr.size() - 1);
    }
}
