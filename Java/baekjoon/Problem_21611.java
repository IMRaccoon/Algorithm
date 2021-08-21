import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_21611 {
    static int N;
    static int SHARK;
    static int SIZE;
    static int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] map;
    static int[] destroyed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        SIZE = N * N;
        map = new int[SIZE];
        destroyed = new int[3];
        SHARK = (N / 2) + 1;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[PosToPoint(i, j)] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());
            int[] dir = dirs[Integer.parseInt(st.nextToken()) - 1];
            int multi = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= multi; i++) {
                map[PosToPoint(SHARK + (dir[0] * i), SHARK + (dir[1] * i))] = 0;
            }
            polling();
            while (destroy()) {
                polling();
            }
            duplication();
        }
        System.out.println(destroyed[0] + (destroyed[1] * 2) + (destroyed[2] * 3));
    }

    private static void printMap() {
        System.out.println();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(map[PosToPoint(i, j)] + "\t");
            }
            System.out.println();
        }
    }

    private static int PosToPoint(int i, int j) {
        int farthest = Math.max(Math.abs(SHARK - i), Math.abs(SHARK - j));
        int standard = (farthest * 2 - 1);
        int base = standard * standard;
        if (Math.abs(SHARK - i) == farthest) {
            if (i > SHARK) base += standard + (j - (SHARK - farthest));
            else base += (standard * 3 + 2) + (SHARK + farthest) - j;
        } else {
            if (j < SHARK) base += i - (SHARK - farthest + 1);
            else base += (standard * 2 + 2) + (SHARK + farthest - 1) - i;
        }
        return base;
    }

    private static void polling() {
        int gap = 1;
        for (int i = 1; i < SIZE; i++) {
            if (map[i] != 0) continue;
            while (i + gap < SIZE && map[i + gap] == 0) {
                gap += 1;
            }
            if (i + gap == SIZE) {
                for (int j = i; j < SIZE; j++) {
                    map[i] = 0;
                }
                break;
            }
            map[i] = map[i + gap];
            map[i + gap] = 0;
        }
    }

    private static boolean destroy() {
        boolean haveToPoll = false;
        int cur = 0, len = 0;
        for (int i = 1; i < SIZE; i++) {
            if (map[i] != cur) {
                if (len >= 4) {
                    haveToPoll = true;
                    for (int j = 1; j <= len; j++) {
                        map[i - j] = 0;
                    }
                    destroyed[cur - 1] += len;
                }
                cur = map[i];
                len = 1;
            } else {
                len += 1;
            }
        }
        return haveToPoll;
    }

    private static void duplication() {
        int[] newMap = new int[SIZE * 2];
        int cur = map[1], len = 1;
        int newIndex = 1;
        for (int i = 2; i < SIZE; i++) {
            if (map[i] != cur) {
                newMap[newIndex++] = len;
                newMap[newIndex++] = cur;
                if (map[i] == 0) break;
                cur = map[i];
                len = 1;
            } else {
                len += 1;
            }
        }
        map = Arrays.copyOf(newMap, SIZE);
    }
}

// 1. 4가지 방향중 한 방향과 거리를 정해서 구슬들을 없앤다.
// 2. 땡긴다.
// 3. 4개 이상 같은 구슬들이 존재한다면 없어진다.
// 4. 땡긴다. 만약 4개 이상 같은 구술이 있다면 3번으로 반복
// 5. 같은 구슬이 붙어있다면 하나의 그룹으로 지정한다. 유일하면 한개가 존재
// 6. 구슬의 개수, 구슬의 번호로 늘어난다.
// 이 모든 과정이 한번의 마법으로 생기는 일들이다.