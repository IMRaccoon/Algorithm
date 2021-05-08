// 5 Score
package dynamic_programming;

public class Way_To_Home {
    public static void main(String[] args) {
        Way_To_Home WTH = new Way_To_Home();
    }
    private Way_To_Home() {
        System.out.println(solution(4, 3, new int[][]{{2, 2}}));
        System.out.println(solution(100, 100, new int[][]{{1,2},{2,1}}));
    }
    public int solution(int m, int n, int [][] pubbles) {
        int [][] route = new int[m][n];
        int water = pubbles.length;
        for(int i = 0 ; i< water; i++)
            route[pubbles[i][0]-1][pubbles[i][1]-1] = -1;
        for(int i = 0 ; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(route[i][j] == -1)
                    route[i][j] = 0;
                else if(i == 0) {
                    if (j == 0)
                        route[i][j] = 1;
                    else
                        route[i][j] = route[i][j-1];
                }
                else if(j == 0)
                    route[i][j] = route[i-1][j];
                else {
                    route[i][j] = route[i - 1][j] + route[i][j - 1];
                    route[i][j] %= 1000000007;
                }
            }
        }
        return route[m-1][n-1];
    }
}