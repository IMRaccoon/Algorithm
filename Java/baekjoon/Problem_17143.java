import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_17143 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken()), C = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());

        Shark[][] map = new Shark[R + 1][C + 1];
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());;
            int speed = Integer.parseInt(st.nextToken()), direction = Integer.parseInt(st.nextToken()), size = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r, c, speed, direction, size);
        }
        int answer = 0;
        ArrayDeque<Shark> save = new ArrayDeque<>();
        for(int i = 1; i <= C && M > 0; i++) {
            for (int r = 1; r <= R; r++) {
                if (map[r][i] != null) {
                    answer += map[r][i].size;
                    M -= 1;
                    map[r][i] = null;
                    break;
                }
            }

            for(int r = 1; r <= R; r ++) {
                for(int c = 1; c <= C; c++) {
                    if(map[r][c] != null) save.offer(map[r][c]);
                }
            }
            map = new Shark[R + 1][C + 1];
            while (!save.isEmpty()) {
                Shark cur = save.poll();
                int nextR = cur.r;
                int nextC = cur.c;

                if (cur.direction <= 2) {
                    if (cur.direction == 1) {
                        nextR -= cur.speed;
                    } else if (cur.direction == 2) {
                        nextR += cur.speed;
                    }
                    while (nextR <= 0 || nextR > R) {
                        if (nextR <= 0) {
                            cur.direction += 1;
                            nextR = Math.abs(nextR) + 2;
                        } else {
                            cur.direction -= 1;
                            nextR = R - (nextR - R);
                        }
                    }
                } else {
                    if (cur.direction == 3) {
                        nextC += cur.speed;
                    } else if (cur.direction == 4) {
                        nextC -= cur.speed;
                    }
                    while (nextC <= 0 || nextC > C) {
                        if (nextC <= 0) {
                            cur.direction -= 1;
                            nextC = Math.abs(nextC) + 2;
                        } else {
                            cur.direction += 1;
                            nextC = C - (nextC - C);
                        }
                    }
                }
                if (map[nextR][nextC] != null) {
                    if (cur.size > map[nextR][nextC].size) map[nextR][nextC] = new Shark(nextR, nextC, cur.speed, cur.direction, cur.size);
                    M -= 1;
                } else {
                    map[nextR][nextC] = new Shark(nextR, nextC, cur.speed, cur.direction, cur.size);
                }
            }
        }
        System.out.println(answer);

    }

    private static class Shark {
        int r, c;
        int speed;
        int direction;
        int size;

        Shark(int r, int c, int speed, int direction, int size) {
            this.r = r;
            this.c = c;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }
    }
}
