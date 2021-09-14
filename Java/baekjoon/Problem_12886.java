import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Problem_12886 {
    static HashSet<Integer> visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int [] arr = new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])};
        if ((arr[0] + arr[1] + arr[2]) % 3 != 0) {
            System.out.println(0);
            return;
        }
        visited = new HashSet<>();
        visited.add(0);
        visited.add(getInt(arr));
        Arrays.sort(arr);
        System.out.println(recursive(arr) ? 1 : 0);

    }

    private static boolean recursive(int [] arr) {
        if(arr[0] == arr[1] && arr[1] == arr[2]) return true;
        int[] next;
        int res;
        next = new int[]{arr[0] + arr[0], arr[1] - arr[0], arr[2]};
        Arrays.sort(next);
        res = getInt(next);
        if (!visited.contains(res)) {
            visited.add(res);
            if (recursive(next)) return true;
        }
        next = new int[]{arr[0] + arr[0], arr[1], arr[2] - arr[0]};
        Arrays.sort(next);
        res = getInt(next);
        if (!visited.contains(res)) {
            visited.add(res);
            if (recursive(next)) return true;
        }
        next = new int[]{arr[0], arr[1] + arr[1], arr[2] - arr[1]};
        Arrays.sort(next);
        res = getInt(next);
        if (!visited.contains(res)) {
            visited.add(res);
            if (recursive(next)) return true;
        }
        return false;
    }

    private static int getInt(int[] arr) {
        if (arr[0] <= 0) return 0;
        return (arr[0] * 250_000) + (arr[1] * 500) + arr[2];
    }
}
