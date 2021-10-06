import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_16916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] S = br.readLine().toCharArray(), P = br.readLine().toCharArray();
        int[] sIndex = new int[P.length];
        int j = 0;
        for (int i = 1; i < P.length; i++) {
            while (j != 0 && P[i] != P[j]) {
                j = sIndex[j - 1];
            }
            if (P[i] == P[j]) sIndex[i] = ++j;
        }
        j = 0;
        for (int i = 0; i < S.length && j < P.length; i++) {
            while (j != 0 && S[i] != P[j]) {
                j = sIndex[j - 1];
            }
            if (S[i] == P[j]) j += 1;
        }
        System.out.println(j == P.length ? 1 : 0);
    }
}