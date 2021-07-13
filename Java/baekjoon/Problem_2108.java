import java.io.*;
import java.util.HashMap;

public class Problem_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int frequency = -1;
        int frequencyCounter = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, tmp;

        for (int i = 0; i < n; i++) {
            int d = Integer.parseInt(br.readLine());
            min = Math.min(min, d);
            max = Math.max(max, d);
            if (map.containsKey(d)) {
                tmp = map.get(d) + 1;
                map.replace(d, tmp);
            } else {
                tmp = 1;
                map.put(d, 1);
            }

            if (frequency < tmp) {
                frequency = tmp;
                frequencyCounter = 1;
            } else if (frequency == tmp) {
                frequencyCounter += 1;
            }

            sum += d;
        }
        bw.write(Math.round((double) sum / (double) n) + "\n");

        int mid = Math.floorDiv(n, 2) + 1;
        int minFrequency = -4001;
        int count = 0;
        boolean midFlag = true, frequencyFlag = true;

        int[] keys = map.keySet().stream().sorted().mapToInt(Integer::intValue).toArray();

        for (int k : keys) {
            tmp = map.get(k);
            if (midFlag) {
                count += tmp;
                if (count >= mid) {
                    bw.write(k + "\n");
                    midFlag = false;
                }
            }
            if (frequencyFlag && (tmp == frequency)) {
                if (frequencyCounter == 1) {
                    minFrequency = k;
                    frequencyFlag = false;
                } else {
                    frequencyCounter = 1;
                }
            }

            if (!frequencyFlag && !midFlag) {
                break;
            }
        }

        bw.write(minFrequency + "\n");
        bw.write(max - min + "\n");
        bw.flush();
    }
}
