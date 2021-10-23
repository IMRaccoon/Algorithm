import java.io.*;

public class Problem_1206 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int t = 1; t <= 10; t++) {
            int N = Integer.parseInt(br.readLine());
            String [] input = br.readLine().split(" ");
            int [] map = new int[N];

            for(int i = 0 ; i < N; i++) {
                map[i] = Integer.parseInt(input[i]);
            }
            int left, right;
            int answer = 0;
            for(int i = 2; i < N - 2; i++) {
                left = Math.max(map[i - 1], map[i - 2]);
                right = Math.max(map [i + 1], map[i + 2]);
                if(map[i] > left && map[i] > right) {
                    answer += map[i] - Math.max(left, right);
                }
            }

            bw.write("#" + t + " " + answer);
            bw.newLine();
        }
        bw.flush();
    }
}
