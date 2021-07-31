import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_11758 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] point = new int[3][2];
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        int area = 0;
        for (int i = 0; i < 3; i++) {
            area += (point[i][0] * point[(i + 1) % 3][1]) - (point[(i + 1) % 3][0] * point[i][1]);
        }
        if (area == 0) {
            System.out.println(0);
        } else {
            System.out.println(area > 0 ? 1 : -1);
        }
    }
}
