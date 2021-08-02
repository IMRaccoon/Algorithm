import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_15686 {
    static boolean [] deleted;
    static int L, M;
    static int answer;
    static ArrayList<Home> homes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        homes = new ArrayList<>();
        ArrayList<Pos> chickens = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                if (tmp == 1) {
                    homes.add(new Home(i, j));
                } else if (tmp == 2) {
                    chickens.add(new Pos(i, j));
                }
            }
        }
        deleted = new boolean[chickens.size()];
        L = chickens.size();
        answer = Integer.MAX_VALUE;
        for (Home h : homes) {
            h.chickens = new int[L];
            Pos c;
            for (int i = 0; i < L; i++) {
                c = chickens.get(i);
                h.chickens[i] = Math.abs(h.n - c.n) + Math.abs(h.m - c.m);
            }
        }
        getCombination(0, 0);
        System.out.println(answer);
    }

    private static void getCombination(int cur, int size) {
        if(size == M) {
            int min = 0;
            for(Home h : homes) {
                int homeMin = Integer.MAX_VALUE;
                for(int i = 0 ; i < L; i++) {
                    if(deleted[i]) homeMin = Math.min(h.chickens[i], homeMin);
                }
                min += homeMin;
            }
            answer = Math.min(min, answer);
        } else {
            for(int i = cur; i < L; i++) {
                deleted[i] = true;
                getCombination(i + 1, size + 1);
                deleted[i] = false;
            }
        }
    }

    private static class Home extends Pos{
        int[] chickens;

        Home(int n, int m) {
            super(n, m);
        }
    }

    private static class Pos {
        int n, m;

        Pos(int n, int m) {
            this.n = n;
            this.m = m;
        }
    }
}
