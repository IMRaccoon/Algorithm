import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Problem_12100 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input;
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        ArrayDeque<int[][]> queue = new ArrayDeque<>();
        queue.offer(map);

        int[][] rotated, push;

        for (int t = 0; t < 5; t++) {
            int size = queue.size();
            while (size-- > 0) {
                int[][] cur = queue.poll();
                for (int r = 0; r < 4; r++) {
                    rotated = new int[N][N];
                    push = new int[N][N];
                    // 돌리고
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            switch (r) {
                                case 0:
                                    rotated[i][j] = cur[i][j];
                                    break;
                                case 1:
                                    rotated[i][j] = cur[N - 1 - j][i];
                                    break;
                                case 2:
                                    rotated[i][j] = cur[N - 1 - i][N - 1 - j];
                                    break;
                                case 3:
                                    rotated[i][j] = cur[j][N - 1 - i];
                                    break;
                            }
                        }
                    }
                    // 복사하고
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            push[i][j] = rotated[i][j];
                        }
                    }
                    for (int j = 0; j < N; j++) {
                        int combine = -1;
                        for (int i = 1; i < N; i++) {
                            if (push[i][j] == 0) continue;
                            int up = i - 1;
                            while (up >= 0 && push[up][j] == 0) {
                                up -= 1;
                            }
                            if (up < 0) push[0][j] = push[i][j];
                            else if (push[i][j] == push[up][j] && combine != up) {
                                push[up][j] += push[i][j];
                                combine = up;
                            } else if (up + 1 == i) continue;
                            else push[up + 1][j] = push[i][j];
                            push[i][j] = 0;
                        }
                    }
                    queue.offer(push);
                }
            }

        }
        int max = 0;
        while (!queue.isEmpty()) {
            int[][] cur = queue.poll();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, cur[i][j]);
                }
            }
        }
        System.out.println(max);
    }
}
