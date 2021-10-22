import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] wheels = new boolean[4][8];
        for (int i = 0; i < 4; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) wheels[i][j] = input[j] == '1';
        }

        int[] cmd;
        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            String[] input = br.readLine().split(" ");
            int index = Integer.parseInt(input[0]) - 1;
            boolean isWatchDir = input[1].equals("1");

            cmd = new int[4];
            cmd[index] = isWatchDir ? 1 : -1;

            for (int j = index - 1; j >= 0; j--) {
                if (wheels[j][2] != wheels[j + 1][6]) cmd[j] = -cmd[j + 1];
                else break;
            }
            for (int j = index + 1; j < 4; j++) {
                if (wheels[j - 1][2] != wheels[j][6]) cmd[j] = -cmd[j - 1];
                else break;
            }
            for(int j = 0; j < 4; j++) {
                if(cmd[j] == 0) continue;
                boolean tmp;
                if(cmd[j] == 1) {
                    tmp = wheels[j][7];
                    for(int k = 7; k > 0; k--) {
                        wheels[j][k] = wheels[j][k - 1];
                    }
                    wheels[j][0] = tmp;
                } else {
                    tmp = wheels[j][0];
                    for(int k = 0; k < 7; k++) {
                        wheels[j][k] = wheels[j][k + 1];
                    }
                    wheels[j][7] = tmp;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < 4; i++) {
            if (wheels[i][0]) answer += (int) Math.pow(2, i);
        }
        System.out.println(answer);
    }
}
