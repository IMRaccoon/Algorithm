import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_17144 {
    static int [][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken()), T = Integer.parseInt(st.nextToken());
        int [][] map = new int[R][C];

        int first = -1, second = -1;
        for(int i = 0 ; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1) {
                    if(first == -1) first = i;
                    else second = i;
                }
            }
        }

        int [][] copy;
        while(T -- != 0) {
            copy = new int[R][C];
            copy[first][0] = copy[second][0] = -1;

            for(int i = 0 ; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] >= 5) {
                        int count = 0;
                        for (int[] dir : dirs) {
                            int nextI = i + dir[0], nextJ = j + dir[1];
                            if (nextI < 0 || nextI >= R || nextJ < 0 || nextJ >= C) continue;
                            if (copy[nextI][nextJ] == -1) continue;
                            copy[nextI][nextJ] += map[i][j] / 5;
                            count += 1;
                        }
                        copy[i][j] += map[i][j] - ((map[i][j] / 5) * count);
                    } else if(map[i][j] > 0) {
                        copy[i][j] += map[i][j];
                    }
                }
            }

            copy[first - 1][0] = 0;
            copy[second + 1][0] = 0;
            for(int i = first - 1; i > 0; i--) {
                copy[i][0] = copy[i - 1][0];
            }
            for(int i = second + 1; i < R - 1; i++) {
                copy[i][0] = copy[i + 1][0];
            }

            for(int i = 0; i < C - 1; i++) {
                copy[0][i] = copy[0][i + 1];
                copy[R - 1][i] = copy[R - 1][i + 1];
            }

            for(int i = 0; i < first; i++) {
                copy[i][C - 1] = copy[i + 1][C - 1];
            }
            for(int i = R - 1; i > second; i--) {
                copy[i][C - 1] = copy[i - 1][C - 1];
            }

            for(int i = C - 1; i > 1; i--) {
                copy[first][i] = copy[first][i - 1];
                copy[second][i] = copy[second][i - 1];
            }

            copy[first][1] = copy[second][1] = 0;

            for(int i = 0 ; i < R; i++) map[i] = Arrays.copyOf(copy[i], C);
        }

        int answer = 0;
        for(int i = 0 ; i < R; i++) {
            for(int j = 0 ; j< C; j++) {
                if(map[i][j] > 0) answer += map[i][j];
            }
        }
        System.out.println(answer);
    }
}
