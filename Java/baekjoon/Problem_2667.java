import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Problem_2667 {
    final static int dir = 4;
    final static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int N;
    static int count;

    static boolean[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        visited = new boolean[N][N];
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j] == '1';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] && !visited[i][j]) {
                    visited[i][j] = true;
                    count = 1;
                    recursive(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (int a : answer) {
            System.out.println(a);
        }
    }

    private static void recursive(int n, int m) {
        int nextN, nextM;
        for (int i = 0; i < dir; i++) {
            nextN = n + dirs[i][0];
            nextM = m + dirs[i][1];

            if (nextN >= 0 && nextN < N && nextM >= 0 && nextM < N && map[nextN][nextM] && !visited[nextN][nextM]) {
                count += 1;
                visited[nextN][nextM] = true;
                recursive(nextN, nextM);
            }
        }
    }
}

