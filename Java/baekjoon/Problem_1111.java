import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        if (N == 1) {
            System.out.println("A");
            return;
        }
        if (N == 2) {
            System.out.println(arr[0] == arr[1] ? arr[0] : "A");
            return;
        }

        if(arr[0] == arr[1]) {
            for(int i = 2; i < N; i++) {
                if(arr[i] != arr[0]) {
                    System.out.println("B");
                    return;
                }
            }
            System.out.println(arr[0]);
            return;
        }
        int A = (arr[2] - arr[1]) / (arr[1] - arr[0]);
        int B = arr[1] - (arr[0] * A);

        for(int i = 2; i < N; i++) {
            if(arr[i] != (A * arr[i - 1]) + B) {
                System.out.println("B");
                return;
            }
        }
        System.out.println(arr[N - 1] * A + B);
    }
}