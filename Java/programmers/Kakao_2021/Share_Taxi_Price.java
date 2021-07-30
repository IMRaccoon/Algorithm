package Kakao_2021;

import java.util.Arrays;

public class Share_Taxi_Price {
    public static void main(String[] args) {
        Share_Taxi_Price s = new Share_Taxi_Price();
        System.out.println(s.solution(6, 4, 6, 2,
                new int[][]{{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}}));
    }

    final int INF = 20_000_001;
    public int solution(int N, int S, int A, int B, int[][] fares) {
        int[][] map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }
        for (int[] fare : fares) {
            map[fare[0]][fare[1]] = fare[2];
            map[fare[1]][fare[0]] = fare[2];
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] > map[i][k] + map[k][j]) {
                        map[i][j] = map[i][k] + map[k][j];
                    }
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            answer = Math.min(map[S][i] + map[i][B] + map[i][A], answer);
        }
        return answer;
    }
}
