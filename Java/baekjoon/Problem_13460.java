import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem_13460 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        char[][] map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        ArrayDeque<char[][]> queue = new ArrayDeque<>();
        queue.offer(map);
        char [][] cur, rotate;

        for(int t = 1; t <= 10; t ++) {
            int size = queue.size();
            for(int a = 0 ; a < size; a++) {
                cur = queue.poll();

                for(int r = 0; r < 4; r++) {
                    boolean move = false, rPull = false, bPull = false;
                    rotate = new char[N][M];
                    for(int b = 0; b < N; b++) {
                        if (M >= 0) System.arraycopy(cur[b], 0, rotate[b], 0, M);
                    }

                    if(r == 0) {
                        for(int j = 1; j < M - 1; j++) {
                            for (int i = 1; i < N - 1; i++) {
                                if(rotate[i][j] == 'R' || rotate[i][j] == 'B') {
                                    int tmp = i - 1;
                                    if(rotate[tmp][j] != '.' && rotate[tmp][j] != 'O') continue;
                                    while(rotate[tmp][j] == '.') tmp -= 1;
                                    if(!move) move = true;
                                    if(rotate[tmp][j] == 'O') {
                                        if(rotate[i][j] == 'B') bPull = true;
                                        else rPull = true;
                                    }
                                    else rotate[tmp + 1][j] = rotate[i][j];
                                    rotate[i][j] = '.';
                                }
                            }
                        }
                        if(move && !bPull) queue.offer(rotate);
                    } else if(r == 1) {
                        for (int j = 1; j < M - 1; j++) {
                            for (int i = N - 2; i >= 1; i--) {
                                if (rotate[i][j] == 'R' || rotate[i][j] == 'B') {
                                    int tmp = i + 1;
                                    if(rotate[tmp][j] != '.' && rotate[tmp][j] != 'O') continue;
                                    while(rotate[tmp][j] == '.') tmp += 1;
                                    if(!move) move = true;
                                    if(rotate[tmp][j] == 'O'){
                                        if(rotate[i][j] == 'B') bPull = true;
                                        else rPull = true;
                                    }
                                    else rotate[tmp - 1][j] = rotate[i][j];
                                    rotate[i][j] = '.';
                                }
                            }
                        }
                        if(move && !bPull) queue.offer(rotate);
                    } else if(r == 2) {
                        for (int i = 1; i < N - 1; i++) {
                            for (int j = M - 2; j >= 1; j--) {
                                if(rotate[i][j] == 'R' || rotate[i][j] == 'B') {
                                    int tmp = j + 1;
                                    if(rotate[i][tmp] != '.' && rotate[i][tmp] != 'O') continue;
                                    while(rotate[i][tmp] == '.') tmp += 1;
                                    if(!move) move = true;
                                    if(rotate[i][tmp] == 'O') {
                                        if(rotate[i][j] == 'B') bPull = true;
                                        else rPull = true;
                                    }
                                    else rotate[i][tmp - 1] = rotate[i][j];
                                    rotate[i][j] = '.';
                                }
                            }
                        }
                        if(move && !bPull) queue.offer(rotate);
                    } else {
                        for(int i = 1; i < N - 1; i++) {
                            for(int j = 1; j < M - 1; j++) {
                                if(rotate[i][j] == 'R' || rotate[i][j] == 'B') {
                                    int tmp = j - 1;
                                    if(rotate[i][tmp] != '.' && rotate[i][tmp] != 'O') continue;
                                    while(rotate[i][tmp] == '.') tmp -= 1;
                                    if(!move) move = true;
                                    if(rotate[i][tmp] == 'O') {
                                        if(rotate[i][j] == 'B') bPull = true;
                                        else rPull = true;
                                    }
                                    else rotate[i][tmp + 1] = rotate[i][j];
                                    rotate[i][j] = '.';
                                }
                            }
                        }
                        if(move && !bPull) queue.offer(rotate);
                    }
                    if(rPull && !bPull) {
                        System.out.println(t);
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}
