import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_4090 {
    static int[] list;
    static int[] pow;
    static int length;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pow = new int[7];
        for (int i = 0; i <= 6; i++) pow[i] = (int) Math.pow(10, i);
        int input;
        while ((input = Integer.parseInt(br.readLine())) > 0) {
            while (true) {
                addList(input);
                if (combination(0, 0, input)) break;
                input++;
            }
            System.out.println(input);
        }
    }

    private static void addList(int input) {
        length = String.valueOf(input).length();
        list = new int[length];
        visited = new boolean[length];
        for (int i = length - 1; i >= 0; i--) {
            list[length - i - 1] = input / pow[i];
            input %= pow[i];
        }
    }

    private static boolean combination(int ACount, int A, int input) {
        if (ACount == length) return false;
        if (ACount > 0 && input % A == 0) {
            int B = input / A;
            int BCount = String.valueOf(B).length();
            if (ACount + BCount == length && checkRest(B, BCount, Arrays.copyOf(visited, length))) return true;
        }

        for (int i = 0; i < length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            if (ACount != 0 || list[i] != 0) {
                if (combination(ACount + 1, A * 10 + list[i], input)) return true;
            }
            visited[i] = false;
        }
        return false;
    }

    private static boolean checkRest(int B, int BCount, boolean[] clone) {
        for (int i = BCount - 1; i >= 0; i--) {
            int target = B / pow[i];
            boolean isExist = false;
            for (int j = 0; j < length; j++) {
                if (list[j] == target && !clone[j]) {
                    clone[j] = true;
                    isExist = true;
                    break;
                }
            }
            if (!isExist) return false;
            B %= pow[i];
        }
        return true;
    }
}
