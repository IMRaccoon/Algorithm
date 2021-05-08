import java.io.*;
import java.util.StringTokenizer;

public class Problem_1991 {
    static BinaryTree[] binaryTrees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        binaryTrees = new BinaryTree[n];
        for(int i = 0 ; i < n; i++) {
            binaryTrees[i] = new BinaryTree((char)('A' + i));
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0) - 'A';
            BinaryTree left = getBinary(st.nextToken().charAt(0));
            BinaryTree right = getBinary(st.nextToken().charAt(0));

            binaryTrees[index].setChild(left, right);
        }

        bw.write(preOrder(binaryTrees[0]) + "\n");
        bw.write(inOrder(binaryTrees[0]) + "\n");
        bw.write(postOrder(binaryTrees[0]) + "\n");

        bw.flush();
    }

    static BinaryTree getBinary(char key) {
        if(key == '.') {
            return null;
        }
        return binaryTrees[key-'A'];
    }

    static String preOrder(BinaryTree cur) {
        if(cur == null) {
            return "";
        }

        return cur.key + preOrder(cur.left) + preOrder(cur.right);
    }

    static String inOrder(BinaryTree cur) {
        if(cur == null) {
            return "";
        }

        return inOrder(cur.left) + cur.key + inOrder(cur.right);
    }

    static String postOrder(BinaryTree cur) {
        if(cur == null) {
            return "";
        }

        return postOrder(cur.left) + postOrder(cur.right) + cur.key;
    }


    static class BinaryTree {
        char key;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(char key) {
            this.key = key;
        }

        public void setChild(BinaryTree left, BinaryTree right) {
            this.left = left;
            this.right = right;
        }

        public boolean isLeftExist() {
            return left != null;
        }

        public boolean isRightExist() {
            return right != null;
        }
    }
}
