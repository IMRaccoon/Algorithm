import java.io.*;
import java.util.*;

public class Problem_4195 {
    static HashMap<String, Integer> hash;
    static int [] parentIndex, size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());
            parentIndex = new int[m * 2];
            size = new int[m * 2];

            for(int j = 0; j < m * 2; j++) {
                size[j] = 1;
                parentIndex[j] = j;
            }

            hash = new HashMap<>();
            int index = 0;
            for(int j = 0 ; j < m; j++) {
                st = new StringTokenizer(br.readLine());

                String firstName = st.nextToken();
                String secondName = st.nextToken();

                if(!hash.containsKey(firstName)) {
                    hash.put(firstName, index ++);
                }
                if(!hash.containsKey(secondName)){
                    hash.put(secondName, index ++);
                }

                bw.write(union(hash.get(firstName), hash.get(secondName)) + "\n");
            }
        }
        bw.flush();
    }

    public static int union(int firstIdx, int secondIdx) {
        int firstRoot = findRoot(firstIdx);
        int secondRoot = findRoot(secondIdx);
        if(firstRoot != secondRoot) {
            parentIndex[secondRoot] = firstRoot;
            size[firstRoot] += size[secondRoot];
        }
        return size[firstRoot];
    }

    public static int findRoot(int index) {
        if(index == parentIndex[index]) {
            return index;
        }
        return findRoot(parentIndex[index]);
    }
}