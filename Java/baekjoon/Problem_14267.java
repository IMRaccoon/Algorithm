import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14267 {
    static int[] parent;
    static int[] compliments;
    static int[] memory;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        compliments = new int[N + 1];
        memory = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int input;
        for (int i = 1; i <= N; i++) {
            input = Integer.parseInt(st.nextToken());
            parent[i] = input;
        }

        int index, compliment;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            index = Integer.parseInt(st.nextToken());
            compliment = Integer.parseInt(st.nextToken());
            compliments[index] += compliment;
        }

        for (int i = 1; i <= N; i++) {
            sb.append(dfs(i)).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static int dfs(int t) {
        if(parent[t] == -1) return 0;
        if(memory[t] == 0) {
            memory[t] = compliments[t] + dfs(parent[t]);
        }
        return memory[t];
    }
}
