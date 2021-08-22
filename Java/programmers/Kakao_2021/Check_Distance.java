package Kakao_2021;

import java.util.Arrays;

public class Check_Distance {
    public static void main(String[] args) {
        Check_Distance cd = new Check_Distance();
        System.out.println(Arrays.toString(cd.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }

    int [][] firstDir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int [][] secondDir = new int[][]{{0, 2}, {0, -2}, {2, 0}, {-2, 0}};
    int [][] thirdDir = new int[][]{{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for(int p = 0 ; p < places.length; p++) {
            int[][] map = new int[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (places[p][i].charAt(j) == 'O') {
                        map[i][j] = 0;
                    } else if (places[p][i].charAt(j) == 'X') {
                        map[i][j] = 1;
                    } else {
                        map[i][j] = -1;
                    }
                }
            }
            boolean isWrong = false;
            int nextN, nextM;
            for (int i = 0; i < 5 && !isWrong; i++) {
                for (int j = 0; j < 5 && !isWrong; j++) {
                    if (map[i][j] == -1) {
                        for (int[] dir : firstDir) {
                            nextN = i + dir[0];
                            nextM = j + dir[1];
                            if (nextN < 0 || nextN >= 5 || nextM < 0 || nextM >= 5) continue;
                            if (map[nextN][nextM] == -1) isWrong = true;
                        }
                        for (int k = 0; k < secondDir.length; k++) {
                            nextN = i + secondDir[k][0];
                            nextM = j + secondDir[k][1];
                            if (nextN < 0 || nextN >= 5 || nextM < 0 || nextM >= 5) continue;
                            if (map[nextN][nextM] == -1 && map[i + firstDir[k][0]][j + firstDir[k][1]] == 0)
                                isWrong = true;
                        }
                        for (int[] dir : thirdDir) {
                            nextN = i + dir[0];
                            nextM = j + dir[1];
                            if (nextN < 0 || nextN >= 5 || nextM < 0 || nextM >= 5) continue;
                            if (map[nextN][nextM] == -1 && (map[nextN][j] == 0 || map[i][nextM] == 0)) isWrong = true;
                        }
                    }
                }
            }
            if (!isWrong) answer[p] = 1;
        }
        return answer;
    }
}
