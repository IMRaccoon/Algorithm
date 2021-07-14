import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), m = Integer.parseInt(br.readLine());
        boolean[] buttonBroken = new boolean[10];

        if (m != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                buttonBroken[Integer.parseInt(st.nextToken())] = true;
            }
        }

        int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;
        boolean minFlag = true, maxFlag = true;
        for (int i = 0; i <= 500000 && (maxFlag || minFlag); i++) {
            if (maxFlag) {
                for (char c : String.valueOf(n + i).toCharArray()) {
                    if (buttonBroken[c - '0']) {
                        maxFlag = false;
                        break;
                    }
                }
                if (!maxFlag) {
                    maxFlag = true;
                } else {
                    max = i + String.valueOf(n + i).length();
                    maxFlag = false;
                }
            }

            if (minFlag) {
                if (n < i) {
                    minFlag = false;
                } else {
                    for (char c : String.valueOf(n - i).toCharArray()) {
                        if (buttonBroken[c - '0']) {
                            minFlag = false;
                            break;
                        }
                    }
                    if (!minFlag) {
                        minFlag = true;
                    } else {
                        min = i + String.valueOf(n - i).length();
                        minFlag = false;
                    }
                }
            }
        }
        System.out.println(Math.min(Math.min(min, max), Math.abs(n - 100)));
    }
}
