import java.io.*;
import java.util.StringTokenizer;

public class Problem_11505 {
    static long[] arr;
    static long DIV = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        SegNode root = new SegNode(0, N - 1);
        root.init();

        while (!(M == 0 && K == 0)) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if (A == 1) {
                M -= 1;
                arr[B-1] = C;
                root.changeValue(B - 1);
            } else {
                K -= 1;
                bw.write(root.findMulti(B - 1, C - 1) + "\n");
            }
        }
        bw.flush();
    }

    private static class SegNode {
        SegNode left, right;
        int l, r;
        long multi;

        SegNode(int l, int r) {
            this.l = l;
            this.r = r;
        }

        void init() {
            if (l == r) {
                this.multi = arr[l];
            } else {
                this.left = new SegNode(l, (l + r) / 2);
                this.right = new SegNode((l + r) / 2 + 1, r);
                this.left.init();
                this.right.init();
                this.multi = (this.left.multi * this.right.multi) % DIV;
            }
        }

        void changeValue(int index) {
            if (l == r && index == l) this.multi = arr[index];
            else {
                int mid = (l + r) / 2;
                if (mid >= index) {
                    this.left.changeValue(index);
                } else {
                    this.right.changeValue(index);
                }
                this.multi = (this.left.multi * this.right.multi) % DIV;
            }
        }

        long findMulti(int l, int r) {
            if (this.l == l && this.r == r) {
                return multi;
            }
            int mid = (this.l + this.r) / 2;
            long res = 1;
            if (mid >= l) {
                res *= this.left.findMulti(l, Math.min(mid, r));
            }
            if (mid < r) {
                res *= this.right.findMulti(Math.max(mid + 1, l), r);
            }
            return res % DIV;
        }
    }
}
