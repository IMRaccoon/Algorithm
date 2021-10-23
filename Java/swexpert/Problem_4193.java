import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Problem_4193 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        int[][] map, dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        String[] input;
        ArrayList<Pos> hurricane, current;
        Pos start, end;
        boolean [][] visited;

        for(int t = 1; t <=T; t++) {
            int N = Integer.parseInt(br.readLine());
            hurricane = new ArrayList<>();
            current = new ArrayList<>();
            map = new int[N][N];
            visited = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    if (input[j].equals("2")) {
                        hurricane.add(new Pos(i, j));
                    } else {
                        map[i][j] = Integer.parseInt(input[j]);
                    }
                }
            }
            input = br.readLine().split(" ");
            start = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            input = br.readLine().split(" ");
            end = new Pos(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
            current.add(start);
            visited[start.n][start.m] = true;

            int time = 0;
            boolean hasChange = false, finish = false;
            while(!finish) {
                if(time % 3 == 0) {
                    hasChange = false;
                    for(Pos h : hurricane) {
                        map[h.n][h.m] = 1;
                    }
                } else if(time % 3 == 2) {
                    for (Pos h : hurricane) {
                        map[h.n][h.m] = 0;
                    }
                }

                int size = current.size();
                for(int i = 0 ; i < size; i++) {
                    Pos cur = current.get(i);
                    int nextN, nextM;
                    for (int[] dir : dirs) {
                        nextN = dir[0] + cur.n;
                        nextM = dir[1] + cur.m;
                        if(nextN < 0 || nextN >= N || nextM < 0 || nextM >= N || visited[nextN][nextM]) continue;
                        if(map[nextN][nextM] == 1) continue;
                        if(nextN == end.n && nextM == end.m) {
                            finish = true;
                            break;
                        }
                        current.add(new Pos(nextN, nextM));
                        visited[nextN][nextM] = true;
                        hasChange = true;
                    }
                }

                time += 1;
                if(time % 3 == 0 && !hasChange) {
                    break;
                }
            }
            if(finish) {
                bw.write("#" + t + " " + time + "\n");
            } else {
                bw.write("#" + t + " " + -1 + "\n");
            }
        }
        bw.flush();
    }

    private static class Pos {
        int n, m;

        Pos(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}