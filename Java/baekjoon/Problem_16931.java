import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_16931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int [][] block = new int[n][m];

        int sum = 0;
        for(int i = 0 ; i< n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j< m; j++) {
                block[i][j] = Integer.parseInt(st.nextToken());

                if(n == 1) {
                    sum += block[i][j] * 2;
                } else if(i == 0) {
                    sum += block[i][j];
                } else if(i == n-1) {
                    sum += block[i][j] + Math.abs(block[i][j] - block[i-1][j]);
                } else {
                    sum += Math.abs(block[i][j] - block[i-1][j]);
                }

                if(m == 1) {
                    sum += block[i][j] * 2;
                } else if(j == 0) {
                    sum += block[i][j];
                } else if(j == m-1) {
                    sum += block[i][j] + Math.abs(block[i][j] - block[i][j-1]);
                } else {
                    sum += Math.abs(block[i][j] - block[i][j-1]);
                }
            }
        }

        sum += (n * m) * 2;
        System.out.println(sum);
    }
}
