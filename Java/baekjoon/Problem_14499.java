import java.io.*;

public class Problem_14499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String [] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]), M = Integer.parseInt(input[1]);
        int x = Integer.parseInt(input[2]), y = Integer.parseInt(input[3]);
        int K = Integer.parseInt(input[4]);

        int [][] dice = new int[4][3];
        int [][] dirs = new int[][] {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        int [][] map = new int[N][M];
        for(int i = 0 ; i < N; i++) {
            input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int [] commands = new int[K];
        input = br.readLine().split(" ");
        for(int i = 0 ; i < K; i++) {
            commands[i] = Integer.parseInt(input[i]) - 1;
        }

        int nextX, nextY, tmp;
        dice[1][1] = map[x][y];

        for(int command : commands) {
            nextX = x + dirs[command][0];
            nextY = y + dirs[command][1];

            if(nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) continue;
            x = nextX;
            y = nextY;

            switch (command) {
                case 0:
                    tmp = dice[1][0];
                    dice[1][0] = dice[1][1];
                    dice[1][1] = dice[1][2];
                    dice[1][2] = dice[3][1];
                    dice[3][1] = tmp;
                    break;
                case 1:
                    tmp = dice[1][2];
                    dice[1][2] = dice[1][1];
                    dice[1][1] = dice[1][0];
                    dice[1][0] = dice[3][1];
                    dice[3][1] = tmp;
                    break;
                case 2:
                    tmp = dice[3][1];
                    dice[3][1] = dice[2][1];
                    dice[2][1] = dice[1][1];
                    dice[1][1] = dice[0][1];
                    dice[0][1] = tmp;
                    break;
                case 3:
                    tmp = dice[0][1];
                    dice[0][1] = dice[1][1];
                    dice[1][1] = dice[2][1];
                    dice[2][1] = dice[3][1];
                    dice[3][1] = tmp;
                    break;
            }

            if(map[x][y] == 0) {
                map[x][y] = dice[1][1];
            } else {
                dice[1][1] = map[x][y];
                map[x][y] = 0;
            }
            bw.write(dice[3][1] + "\n");
        }
        bw.flush();
    }
}


