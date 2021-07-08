import java.io.*;
import java.util.*;

public class Problem_16235 {
    static final int dir = 8;
    static final int [][] dirs = {{-1, 0}, {-1, 1}, {-1, -1}, {0, 1}, {0, -1}, {1, 0}, {1, 1}, {1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] originMap = new int[n][n];
        int[][] map = new int[n][n];
        Tree [] init = new Tree[m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                originMap[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            init[i] = new Tree(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(init);
        ArrayDeque<Tree> trees = new ArrayDeque<>(Arrays.asList(init));

        ArrayDeque<Tree> deadTrees = new ArrayDeque<>();
        ArrayDeque<int[]> updateTree = new ArrayDeque<>();
        int nr, nc, size;

        for(int i = 0 ; i < k; i++) {
            size = trees.size();
            for(int j = 0 ; j < size; j++) {
                Tree t = trees.pollFirst();
//                System.out.println((i + 1) + "년, 나무 위치 (" + t.r + ", " + t.c + ") 나무 나이: " + t.age + " 위치 양분: " + map[t.r][t.c]);
                if (t.age <= map[t.r][t.c]) {
                    map[t.r][t.c] -= t.age;
                    t.age += 1;
                    if (t.age % 5 == 0) {
                        updateTree.add(new int[]{t.r, t.c});
                    }
                    trees.addLast(t);
                } else {
                    deadTrees.add(t);
                }
            }

            size = updateTree.size();
            for(int j = 0 ; j < size; j++) {
                int [] pos = updateTree.pop();

                for(int d = 0; d< dir; d++) {
                    nr = pos[0] + dirs[d][0];
                    nc = pos[1] + dirs[d][1];

                    if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= n - 1) {
                        trees.addFirst(new Tree(nr, nc, 1));
                    }
                }
            }

            size = deadTrees.size();
            for(int j = 0 ; j < size; j++) {
                Tree t = deadTrees.pop();
                map[t.r][t.c] += Math.floorDiv(t.age, 2);
            }

            for(int r = 0; r < n; r++) {
                for(int c = 0; c < n; c ++) {
                    map[r][c] += originMap[r][c];
                }
            }
        }

        System.out.println(trees.size());

    }


    private static class Tree implements Comparable<Tree> {
        int r;
        int c;
        int age;

        Tree(int r, int c, int age) {
            this.r = r;
            this.c = c;
            this.age = age;
        }

        @Override
        public int compareTo(Tree tree) {
            return this.age - tree.age;
        }
    }
}

