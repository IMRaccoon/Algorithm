import java.io.*;
import java.util.StringTokenizer;

public class Problem_2263 {
    static int[] inOrder, postOrder, preOrder;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        inOrder = new int[N];
        postOrder = new int[N];
        preOrder = new int[N];
        index = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        recursive(0, N - 1, 0, N - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(preOrder[i]).append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void recursive(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart <= inEnd && postStart <= postEnd) {
            preOrder[index++] = postOrder[postEnd];
            int pos = inStart;
            for (int i = inStart; i <= inEnd; i++) {
                if (inOrder[i] == postOrder[postEnd]) {
                    pos = i;
                    break;
                }
            }
            recursive(inStart, pos - 1, postStart, postStart + pos - inStart - 1);
            recursive(pos + 1, inEnd, postStart + pos - inStart, postEnd - 1);
        }
    }
}