import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_19542 {
    static int[] distances;
    static ArrayList<Integer>[] arr;
    static int N, S, D;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken()) - 1;
        D = Integer.parseInt(st.nextToken());
        count = -1;

        arr = new ArrayList[N];
        distances = new int[N];

        int x, y;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;

            if (arr[x] == null) {
                arr[x] = new ArrayList<>();
            }
            if (arr[y] == null) {
                arr[y] = new ArrayList<>();
            }
            arr[x].add(y);
            arr[y].add(x);
        }

        distances[S] = 1;
        checkDistance(S);

        for (int i = 0; i < N; i++) {
            if (distances[i] <= D) arr[i] = null;
        }
        Arrays.fill(distances, 0);
        distances[S] = 1;
        if(arr[S] == null) {
            System.out.println(0);
            return;
        }
        dfs(S);

        System.out.println((distances[S] - 1) * 2);
    }

    static void checkDistance(int t) {
        for (int a : arr[t]) {
            if(distances[a] == 0) {
                distances[a] = 1;
                checkDistance(a);
                distances[t] = Math.max(distances[t], distances[a] + 1);
            }
        }
    }

    static void dfs(int t) {
        for (int a : arr[t]) {
            if(distances[a] == 0) {
                if(arr[a] == null) continue;

                distances[a] = 1;
                dfs(a);
                distances[t] += distances[a];
            }
        }
    }
}
