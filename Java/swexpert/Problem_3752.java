import java.io.*;
import java.util.*;

public class Problem_3752 {
    static int[] map;
    static int N;
    static Set<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] input;

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            map = new int[N];
            answer = new HashSet<>();

            for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(input[i]);
            }
            answer.add(0);
            for(int i = 0 ; i < N; i++) {
                Set<Integer> tmp = new HashSet<>(answer);
                for (Integer integer : tmp) {
                    answer.add(integer + map[i]);
                }
            }

            bw.write("#" + t + " " + answer.size() + "\n");
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
