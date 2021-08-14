import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1062 {
    static HashSet<Integer> set;
    static boolean[][] map;
    static Integer[] arr;
    static boolean [] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken()) - 5;
        set = new HashSet<>();
        map = new boolean[N][26];
        visited = new boolean[26];

        for (int i = 0; i < N; i++) {
            strToBool(br.readLine().toCharArray(), map[i]);
        }
        set.remove(0);
        set.remove(2);
        set.remove(8);
        set.remove(13);
        set.remove(19);

        if (K < 0) {
            System.out.println(0);
        } else if (set.size() <= K) {
            System.out.println(N);
        } else {
            arr = set.toArray(Integer[]::new);
            System.out.println(combination(0, K));
        }
    }
    private static int combination(int start, int count) {
        int max = 0;
        if (count == 0) {
            boolean canAdd;
            for (boolean[] str : map) {
                canAdd = true;
                for (int i = 0; i < 26; i++) {
                    if (!str[i] || str[i] && visited[i]) continue;
                    canAdd = false;
                    break;
                }
                if(canAdd) max += 1;
            }
            return max;
        }

        for (int i = start; i < arr.length; i++) {
            visited[arr[i]] = true;
            max = Math.max(max, combination(i + 1, count - 1));
            visited[arr[i]] = false;
        }
        return max;
    }

    private static void strToBool(char[] str, boolean[] map) {
        for (char c : str) {
            map[c - 'a'] = true;
            set.add(c - 'a');
        }
        map[0] = map[2] = map[8] = map[13] = map[19] = false;
    }
}
