import java.io.*;
import java.util.StringTokenizer;

public class Problem_6549 {
    static long[] arr;
    static TreeNode[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            arr = new long[N + 1];
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            nodes = new TreeNode[N * 4];
            initTree(1, N, 1);

            bw.write(allMin(1, N) + "\n");
        }
        bw.flush();
    }

    private static void initTree(int start, int end, int index) {
        if (start == end) {
            nodes[index] = new TreeNode(start, end, start);
        } else {
            int mid = (start + end) / 2;
            initTree(start, mid, index * 2);
            initTree(mid + 1, end, index * 2 + 1);
            long left = arr[nodes[index * 2].index], right = arr[nodes[index * 2 + 1].index];
            nodes[index] = new TreeNode(start, end, nodes[left > right ? index * 2 + 1 : index * 2].index);
        }
    }

    private static int findMin(int start, int end, int index) {
        TreeNode cur = nodes[index];
        if (cur.start == start && cur.end == end) {
            return cur.index;
        }

        int res = -1;
        cur = nodes[index * 2];
        if (cur.end >= start) {
            res = findMin(start, Math.min(end, cur.end), index * 2);
        }
        cur = nodes[index * 2 + 1];
        if (cur.start <= end) {
            int tmp = findMin(Math.max(start, cur.start), end, index * 2 + 1);
            if (res == -1) res = tmp;
            else {
                if (arr[res] > arr[tmp]) res = tmp;
            }
        }
        return res;
    }

    private static long allMin(int start, int end) {
        if (start > end) return 0;
        if (start == end) return arr[start];

        int minIndex = findMin(start, end, 1);
        long left = allMin(start, minIndex - 1);
        long right = allMin(minIndex + 1, end);
        return Math.max((end - start + 1) * arr[minIndex], Math.max(left, right));
    }


    private static class TreeNode {
        int start, end, index;

        TreeNode(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }
    }
}