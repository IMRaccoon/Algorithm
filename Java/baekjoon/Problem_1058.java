import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1058 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(br.readLine());

        boolean[][] friendMap = new boolean[number][number];

        for (int i = 0; i < number; i++) {
            char[] tmp = br.readLine().toCharArray();
            for (int j = 0; j < number; j++) {
                if (tmp[j] == 'Y') {
                    friendMap[i][j] = true;
                }
            }
        }

        int max = -1;

        for (int i = 0; i < number; i++) {
            boolean[] secondFriends = Arrays.copyOf(friendMap[i], number);
            secondFriends[i] = true;
            for (int j = 0; j < number; j++) {
                if (friendMap[i][j]) {
                    combineFriend(secondFriends, friendMap[j]);
                }
            }
            max = Math.max(checkFriends(secondFriends) - 1, max);
        }

        System.out.println(max);
    }

    public static int checkFriends(boolean[] src) {
        int counter = 0;
        for (boolean s : src) {
            if (s) {
                counter++;
            }
        }
        return counter;
    }

    public static void combineFriend(boolean[] src, boolean[] target) {
        for (int i = 0; i < src.length; i++) {
            src[i] = src[i] | target[i];
        }
    }
}
