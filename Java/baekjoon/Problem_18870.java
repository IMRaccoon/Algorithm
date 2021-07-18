import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Problem_18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        HashMap<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int s : sortNums) {
            if (!map.containsKey(s)) {
                map.put(s, idx++);
            }
        }
        for (Integer s : nums) {
            sb.append(map.get(s)).append(" ");
        }
        System.out.println(sb.toString());
    }
}