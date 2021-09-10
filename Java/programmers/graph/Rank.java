package graph;


public class Rank {
    public static void main(String[] args) {
        Rank rank = new Rank();
    }
    private Rank() {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
        System.out.println(solution(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }
    public int solution(int n, int [][] results) {
        boolean [][] meet = new boolean[n + 1][n + 1];
        for(int [] result: results) {
            meet[result[0]][result[1]] = true;
        }

        for(int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if(i != j && meet[i][k] && meet[k][j]) meet[i][j] = true;
                }
            }
        }
        int count = 0;

        for(int i = 1; i <= n; i++) {
            boolean isFull = true;
            for(int j = 1; j <= n; j++) {
                if(i != j && !(meet[i][j] || meet[j][i])) {
                    isFull = false;
                    break;
                }
            }
            if(isFull) count += 1;
        }

        return count;
    }
}
