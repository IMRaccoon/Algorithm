import java.io.*;
import java.util.HashSet;

public class Problem_1244 {
    static char[] num;
    static int answer;
    static int length;
    static HashSet<Integer>[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] input = br.readLine().split(" ");
            num = input[0].toCharArray();
            int E = Integer.parseInt(input[1]);
            length = num.length;
            answer = 0;
            visited = new HashSet[E + 1];
            for(int i = 1; i <= E; i++) {
                visited[i] = new HashSet<>();
            }

            backtracking(E);
            bw.write("#" + t + " " + answer);
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static void backtracking(int count) {
        if (count == 0) {
            answer = Math.max(answer, Integer.parseInt(String.valueOf(num)));
            return;
        }

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                char tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
                if(!visited[count].contains(Integer.parseInt(String.valueOf(num)))) {
                    visited[count].add(Integer.parseInt(String.valueOf(num)));
                    backtracking(count - 1);
                }
                num[j] = num[i];
                num[i] = tmp;
            }
        }
    }
}
