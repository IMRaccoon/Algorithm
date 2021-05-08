package Kakao_2017;

import java.util.Arrays;

public class KakaoFriends_Coloring {
    public static void main(String[] args) {
        KakaoFriends_Coloring KC = new KakaoFriends_Coloring();
    }
    private KakaoFriends_Coloring() {
        System.out.println(Arrays.toString(solution(6,4, new int[][] {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3}, {0,0,0,3}})));
    }
    boolean [][] map;
    int x;
    int y;
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        x = m;
        y = n;
        map = new boolean[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j< n; j++) {
                if(picture[i][j] != 0 && !map[i][j]) {
                    int tmp_area = recursive(i, j, picture);
                    numberOfArea += 1;
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, tmp_area);
                }
            }
        }
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }

    public int recursive(int i, int j, int [][] picture) {
        map[i][j] = true;
        int area = 1;
        if(j+1 != y && !map[i][j+1] && picture[i][j] == picture[i][j+1]) {
            area += recursive(i, j+1, picture);
        }
        if(i+1 != x && !map[i+1][j] &&picture[i][j] == picture[i+1][j]) {
            area += recursive(i+1, j, picture);
        }
        if(j-1 != -1 && !map[i][j-1] &&picture[i][j] == picture[i][j-1]) {
            area += recursive(i, j-1, picture);
        }
        if(i-1 != -1 && !map[i-1][j] && picture[i][j] == picture[i-1][j]) {
            area += recursive(i-1, j, picture);
        }
        return area;
    }
}
