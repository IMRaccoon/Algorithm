import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14890 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), L = Integer.parseInt(input[1]);

        short[][] map = new short[N][N];
        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Short.parseShort(input[j]);
            }
        }
        int answer = 0, height, count;
        for(int i = 0 ; i < N; i++) {
            height = map[i][0];
            count = 1;
            int j = 1;
            while(j < N) {
                if (height == map[i][j]) count += 1;
                else if(Math.abs(height - map[i][j]) != 1) {
                    count = -1;
                    break;
                }
                else if(count < 0) break;
                else if (height < map[i][j]) {
                    if (count >= L) {
                        height = map[i][j];
                        count = 1;
                    } else {
                        count = -1;
                        break;
                    }
                } else {
                    height = map[i][j];
                    count = - L + 1;
                }
                j += 1;
            }
            if(count >= 0) {
                answer += 1;
            }
        }
        for(int j = 0 ; j < N; j++) {
            height = map[0][j];
            count = 1;
            int i = 1;
            while(i < N) {
                if (height == map[i][j]) count += 1;
                else if(Math.abs(height - map[i][j]) != 1) {
                    count = -1;
                    break;
                }
                else if(count < 0) break;
                else if (height < map[i][j]) {
                    if (count >= L) {
                        height = map[i][j];
                        count = 1;
                    } else {
                        count = -1;
                        break;
                    }
                } else {
                    height = map[i][j];
                    count = - L + 1;
                }
                i += 1;
            }
            if(count >= 0) {
                answer += 1;
            }
        }
        System.out.println(answer);
    }
}
