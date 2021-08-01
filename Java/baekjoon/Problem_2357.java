import java.io.*;
import java.util.StringTokenizer;

public class Problem_2357 {
    static Tree[] tree;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];
        tree = new Tree[N * 4];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        initTree(1, N, 1);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            bw.write(findNum(start, end, 1, false) + " " + findNum(start, end, 1, true) + "\n");
        }
        bw.flush();
    }

    private static void initTree(int start, int end, int index) {
        if (start == end) {
            tree[index] = new Tree(start, end, arr[start], arr[start]);
        } else {
            int mid = (start + end - 1) / 2;
            initTree(start, mid, index * 2);
            initTree(mid + 1, end, (index * 2) + 1);
            tree[index] = new Tree(start, end, Math.max(tree[index * 2].max, tree[index * 2 + 1].max), Math.min(tree[index * 2].min, tree[index * 2 + 1].min));
        }
    }

    private static long findNum(int start, int end, int index, boolean isMax) {
        Tree cur = tree[index];
        if(cur.start == start && cur.end == end) {
            return isMax ? cur.max : cur.min;
        }
        long value = isMax ? 0 : Long.MAX_VALUE;
        long res;

        Tree left = tree[index * 2];
        if (left.end >= start) {
            res = findNum(start, Math.min(left.end, end), index * 2, isMax);
            value = isMax ? Math.max(res, value) : Math.min(res, value);
        }

        Tree right = tree[index * 2 + 1];
        if (right.start <= end) {
            res = findNum(Math.max(start, right.start), end, index * 2 + 1, isMax);
            value = isMax ? Math.max(res, value) : Math.min(res, value);
        }
        return value;
    }

    private static class Tree {
        int start, end;
        long max, min;

        Tree(int start, int end, long max, long min) {
            this.start = start;
            this.end = end;
            this.max = max;
            this.min = min;
        }
    }
}