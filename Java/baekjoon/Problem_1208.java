import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Problem_1208 {
    static int N, S;
    static BigInteger answer;
    static int[] elements;
    static ArrayDeque<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        elements = new int[N];
        queue = new ArrayDeque<>();
        answer = new BigInteger("0");
        BigInteger one = new BigInteger("1");

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            elements[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();
        int tmp, size;

        for (int i = 0; i < N / 2; i++) {
            size = first.size();
            for (int j = 0; j < size; j++) {
                tmp = first.get(j) + elements[i];
                if (tmp == S) answer = answer.add(one);
                first.add(tmp);
            }
            if(elements[i] == S) answer = answer.add(one);
            first.add(elements[i]);
        }

        for (int i = 0; i < (N + 1) / 2; i++) {
            size = second.size();
            for (int j = 0; j < size; j++) {
                tmp = second.get(j) + elements[N - i - 1];
                if (tmp == S) answer = answer.add(one);
                second.add(tmp);
            }
            if(elements[N - i - 1] == S) answer = answer.add(one);
            second.add(elements[N - i - 1]);
        }
        first.sort(Comparator.naturalOrder());
        second.sort(Comparator.reverseOrder());
        BigInteger sumI, sumJ;
        int firstSize = first.size(), secondSize = second.size();
        int i = 0, j = 0;
        while (i < firstSize && j < secondSize) {
            if (first.get(i) + second.get(j) == S) {
                int tmpI = i, tmpJ = j;
                while (++tmpI < firstSize && first.get(tmpI).equals(first.get(i))) {
                }
                while (++tmpJ < secondSize && second.get(tmpJ).equals(second.get(j))) {
                }
                sumI = new BigInteger(String.valueOf(tmpI - i));
                sumJ = new BigInteger(String.valueOf(tmpJ - j));
                answer = answer.add(sumI.multiply(sumJ));
                i = tmpI;
                j = tmpJ;
            } else {
                if (first.get(i) + second.get(j) > S) j++;
                else i++;
            }
        }
        System.out.println(answer);
    }
}
