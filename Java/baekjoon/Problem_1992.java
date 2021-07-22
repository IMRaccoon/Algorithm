import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1992 {
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = input[j] == '1';
            }
        }
        System.out.println(recursive(0, N, 0, N));
    }

    private static String recursive(int startI, int endI, int startJ, int endJ) {
        boolean init = map[startI][startJ];
        for(int i = startI; i < endI; i++) {
            for(int j = startJ; j < endJ; j++) {
                StringBuilder val = new StringBuilder("(");
                int half = (endI - startI) / 2;
                if(init ^ map[i][j]) {
                    val.append(recursive(startI, startI + half, startJ, startJ + half));
                    val.append(recursive(startI, startI + half, startJ + half, endJ));
                    val.append(recursive(startI + half, endI, startJ, startJ + half));
                    val.append(recursive(startI + half, endI, startJ + half, endJ));
                    val.append(")");
                    return val.toString();
                }
            }
        }
        return init ? "1" : "0";
    }

}
