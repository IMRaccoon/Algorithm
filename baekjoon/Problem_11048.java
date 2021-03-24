import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        int [][] maze = new int[n][m];
        int [][] calculateCandy = new int[n][m];

        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());

                if(i == 0 && j == 0) {
                    calculateCandy[i][j] = maze[i][j];
                } else if(i == 0) {
                    calculateCandy[i][j] = calculateCandy[i][j-1] + maze[i][j];
                } else if(j == 0) {
                    calculateCandy[i][j] = calculateCandy[i-1][j] + maze[i][j];
                } else {
                    calculateCandy[i][j] = Math.max(calculateCandy[i-1][j] + maze[i][j], calculateCandy[i][j-1] + maze[i][j]);
                }
            }
        }
        System.out.println(calculateCandy[n-1][m-1]);
    }
}
