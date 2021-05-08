import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int [] arr = new int[8001];
        float sum = 0;
        for(int i = 0 ; i < n; i++) {
            int d = Integer.parseInt(br.readLine());
            arr[d + 4000]++;
            sum += d;
        }
        System.out.println(Math.round(sum / (float)n));

        int mid = 0, min = 0, max = 0;
        int index = 0;
        for(int i = 0 ; i <= 8000; i++) {
            if(arr[i] != 0) {
                if(index == 0) {
                    min = arr[i] - 4000;
                }
                index += arr[i];

                if(mid == 0 && (index + 1) * 2 >= n) {
                    mid = arr[i] - 4000;
                }
                if(index == n) {
                    max = arr[i] - 4000;
                }
            }
        }
        System.out.println(mid);
        System.out.println(min);
        System.out.println(max - min);
    }
}
