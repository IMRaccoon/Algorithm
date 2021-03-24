// 6 Score
package level_2;

public class Solve_35 {
    public static void main(String[] args) {
        Solve_35 sol = new Solve_35();
    }
    private Solve_35() {
        System.out.println(solution(new int[][]{{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 5}}));
    }

    public int solution(int [][] land) {
        for(int i = 0 ; i< land.length-1; i++) {
            land[i+1][0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
            land[i+1][1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
            land[i+1][2] += Math.max(land[i][1], Math.max(land[i][0], land[i][3]));
            land[i+1][3] += Math.max(land[i][1], Math.max(land[i][2], land[i][0]));
        }
        return Math.max(land[land.length-1][0], Math.max(land[land.length-1][1], Math.max(land[land.length-1][2], land[land.length-1][3])));
    }
}
