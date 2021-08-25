import java.io.*;
import java.util.ArrayList;

public class Problem_15681 {
    static ArrayList<Integer>[] child;
    static int [] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        int Q = Integer.parseInt(input[2]);

        child = new ArrayList[N + 1];
        nodes = new int[N + 1];

        for(int i = 1; i <= N; i++) child[i] = new ArrayList<>();
        for(int i = 0 ; i < N - 1; i++) {
            input = br.readLine().split(" ");
            child[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
            child[Integer.parseInt(input[1])].add(Integer.parseInt(input[0]));
        }
        findEachSub(R);
        for(int i = 0 ; i < Q; i++) {
            bw.write(nodes[Integer.parseInt(br.readLine())] + "\n");
        }
        bw.flush();
    }

    private static void findEachSub(int root) {
        nodes[root] += 1;
        if(!child[root].isEmpty()) {
            for(int sub : child[root]) {
                if(nodes[sub] != 0) continue;
                findEachSub(sub);
                nodes[root] += nodes[sub];
            }
        }
    }
}
