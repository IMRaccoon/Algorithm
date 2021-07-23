import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1685 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] index = new int[N];
        for (int i = 0; i < N; i++) {
            index[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());

        int lastIndex = (index[N - 1] * index[N - 1]);
        int[] map = new int[lastIndex + 1];

        for(int i = 0 ; i < N; i++) {
            map[index[i]] = 1;
        }

        int answer = -1;
        int maxCount = 0;
        int maxNum = 0;
        int maxIndex = N;

        for(int i = 1; i < lastIndex; i++) {
            if (map[i] == 0 || map[i] > M) {
                answer = i;
                break;
            } else if(maxCount < map[i]) {
                maxCount = map[i];
                maxNum = i;
            }
            for (int j = 0; j < maxIndex; j++) {
                if (i + index[j] <= lastIndex) {
                    map[i + index[j]] = map[i + index[j]] == 0 ? map[i] + 1 : Math.min(map[i] + 1, map[i + index[j]]);
                } else {
                    maxIndex = j;
                }
            }
        }

        if(answer == -1) {
            answer = (M - maxCount + 1) * index[N - 1] + maxNum;
        }
        if(answer % 2 == 0) {
            System.out.println("holsoon win at " + answer);
        } else {
            System.out.println("jjaksoon win at " + answer);
        }
    }
}
