// 4 Score
package Kakao_2018;

public class Friends_4Blocks {
    public static void main(String[] args) {
        Friends_4Blocks friend = new Friends_4Blocks();
    }
    private Friends_4Blocks() {
        System.out.println(solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(solution(6,6, new String[]{"TTTANT","RRFACC","RRRFCC","TRRRAA","TTMMMF","TMMTTJ"}));
    }
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        int [][] zero = new int[m][n];
        int [][] block = new int[m][n];
        for(int i = 0 ; i< m; i++) {
            for(int j = 0; j<n; j++) {
                block[i][j] = board[i].charAt(j);
            }
        }
        do {
            for (int i = m-2; i >= 0; i--) {
                for (int j = n-2; j >= 0; j--) {
                    if ((block[i][j] == block[i+1][j]) && (block[i][j] == block[i][j+1]) && (block[i][j] == block[i+1][j+1])  &&  block[i][j] != 0) {               // 주변 세 개의 블럭이 0이거나 같은 숫자일 경우
                        zero[i][j] = 1;
                    }
                }
            }
            for (int i = m-2; i >= 0; i--) {
                for (int j = n-2; j >= 0; j--) {
                    if (zero[i][j] == 1) {               // 주변 세 개의 블럭이 0이거나 같은 숫자일 경우
                        block[i][j] = 0;
                        block[i+1][j] = 0;
                        block[i][j+1] = 0;
                        block[i+1][j+1] = 0;
                        zero[i][j] = 0;
                    }
                }
            }
        }while(setBoard(block));
        for(int i = 0 ; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(block[i][j] == 0)
                    answer+=1;
            }
        }
        return answer;
    }
    public boolean setBoard(int[][] block) {
        boolean returnvalue = false;
        int flag;
        for(int i = block.length-2; i >= 0; i--) {
            for(int j = block[0].length-1; j >= 0; j--) {
                flag = i;
                while(flag+1 != block.length && block[flag+1][j] == 0 && block[flag][j] != 0) {
                    block[flag+1][j] = block[flag][j];
                    block[flag][j] = 0;
                    flag++;
                    returnvalue = true;
                }
            }
        }
        return returnvalue;
    }
}
