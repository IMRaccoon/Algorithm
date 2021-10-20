import java.io.*;

public class Problem_14888 {
    static int[] arr, opers;
    static int N, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        opers = new int[4];
        input = br.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            opers[i] = Integer.parseInt(input[i]);
        }
        recursive(0, arr[0]);
        bw.write(max + "\n" + min);
        bw.flush();
    }

    private static void recursive(int count, int acc) {
        if (count == N - 1) {
            min = Math.min(min, acc);
            max = Math.max(max, acc);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (opers[i] == 0) continue;
            opers[i] -= 1;
            switch (i) {
                case 0:
                    recursive(count + 1, acc + arr[count + 1]);
                    break;
                case 1:
                    recursive(count + 1, acc - arr[count + 1]);
                    break;
                case 2:
                    recursive(count + 1, acc * arr[count + 1]);
                    break;
                case 3:
                    recursive(count + 1, acc / arr[count + 1]);
                    break;
            }
            opers[i] += 1;
        }
    }
}