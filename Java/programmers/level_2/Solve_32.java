// 10 Score
package level_2;

public class Solve_32 {
    public static void main(String[] args) {
        Solve_32 sol = new Solve_32();
    }

    private Solve_32() {
        System.out.println(solution2(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}}));
        System.out.println(solution2(new int[][]{{0, 0, 1, 1}, {1, 1, 1, 1}}));
    }

    public int solution(int[][] board) {                                // Didn't Pass at the Effectiveness
        int i, j, answer = 0;
        for(i = 0; i< board.length - answer; i++) {
            for(j = 0; j < board[0].length - answer; j++) {
                if(board[i][j] == 1) {
                    for(int k = answer; k<= Math.min(board.length - i, board[0].length - j) ; k++) {
                        if(checkAnswer(board, i, j , k))
                            answer = Math.max(answer, k);
                    }
                }
            }
        }
        return answer * answer;
    }
    public boolean checkAnswer(int [][] board, int a, int b, int flag) {
        for(int i = 0 ; i < flag; i++) {
            for(int j = 0 ; j<flag; j++) {
                if(board[a+i][b+j] == 0)
                    return false;
            }
        }
        return true;
    }


    public int solution2(int [][] board) {                                     // Problem Solve
        int i, j, answer = 0;
        for(i = 1; i < board.length; i++)
            for(j = 1; j < board[0].length; j++)
                if (board[i][j] == 1)
                    board[i][j] += Min(board[i-1][j], board[i][j-1], board[i-1][j-1]);
        for(i = 0; i<board.length; i++)
            for(j = 0 ; j<board[0].length; j++) {
                answer = Math.max(answer, board[i][j]);
            }
        return answer * answer;
    }
    int Min(int a, int b, int c) {
        a = a < b? a:b;
        return a<c ? a:c;
    }
}
