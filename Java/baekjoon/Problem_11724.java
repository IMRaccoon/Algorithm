import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_11724 {
    static int [] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        map = new int[n + 1];

        int a, b;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if (map[a] == 0 && map[b] == 0) {
                map[a] = Math.min(a, b);
                map[b] = Math.min(a, b);
            } else if (map[a] == 0) {
                if (a < getRoot(b)) {
                    map[a] = a;
                    map[getRoot(b)] = a;
                } else {
                    map[a] = getRoot(b);
                }
            } else if (map[b] == 0) {
                if (getRoot(a) < b) {
                    map[b] = getRoot(a);
                } else {
                    map[getRoot(a)] = b;
                    map[b] = b;
                }
            } else {
                if (getRoot(a) < getRoot(b)) {
                    map[getRoot(b)] = getRoot(a);
                } else {
                    map[getRoot(a)] = getRoot(b);
                }
            }
        }
        int answer = 0;
        HashSet<Integer> spices = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            if (map[i] == 0) {
                answer += 1;
            } else {
                if (spices.add(getRoot(i))) {
                    answer += 1;
                }
            }
        }
        System.out.println(answer);
    }

    private static int getRoot(int index) {
        int tmp = index;
        while(map[tmp] != tmp) {
            tmp = map[tmp];
        }
        return tmp;
    }
}
