import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), X = Integer.parseInt(st.nextToken());

        ArrayList<Pair>[] nature = new ArrayList[N + 1], reverse = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            nature[i] = new ArrayList<>(); reverse[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()), end = Integer.parseInt(st.nextToken()), dist = Integer.parseInt(st.nextToken());
            nature[start].add(new Pair(end, dist)); reverse[end].add(new Pair(start, dist));
        }
        int[] toX = new int[N + 1];
        int[] fromX = new int[N + 1];
        Arrays.fill(toX, 1000000);
        Arrays.fill(fromX, 1000000);
        toX[X] = 0; fromX[X] = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();
        findDistance(X, nature, toX, q);
        q = new ArrayDeque<>();
        findDistance(X, reverse, fromX, q);

        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(toX[i] + fromX[i], max);
        }
        System.out.println(max);
    }

    private static void findDistance(int x, ArrayList<Pair>[] nature, int[] arr, ArrayDeque<Integer> q) {
        q.offer(x);

        while(!q.isEmpty()) {
            int cur = q.poll();
            for (Pair p : nature[cur]) {
                if (arr[p.dest] > arr[cur] + p.distance) {
                    arr[p.dest] = arr[cur] + p.distance;
                    q.offer(p.dest);
                }
            }
        }
    }

    private static class Pair {
        int dest;
        int distance;

        Pair(int dest, int distance) {
            this.dest = dest;
            this.distance = distance;
        }
    }
}