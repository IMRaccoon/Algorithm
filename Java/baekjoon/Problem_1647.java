import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_1647 {
    static int [] union;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        union = new int[n + 1];
        int a, b, c;

        ArrayList<Route> list = new ArrayList<>();

        for(int i = 0 ; i < m ; i ++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            list.add(new Route(a, b, c));
        }
        list.sort(Comparator.comparingInt(route -> route.maintain));

        for(int i = 1; i <= n; i++) {
            union[i] = i;
        }

        int sum = 0;
        int max = 0;

        for(Route r : list) {
            int townA = getParent(r.townA);
            int townB = getParent(r.townB);

            if(townA == townB) continue;

            if(townA < townB) {
                union[townB] = townA;
            } else {
                union[townA] = townB;
            }
            sum += r.maintain;
            max = r.maintain;
        }

        System.out.println(sum - max);
    }

    private static int getParent(int index) {
        while(union[index] != index) {
            index = union[index];
        }
        return index;
    }

    private static class Route implements Comparable<Route> {
        int townA;
        int townB;
        int maintain;

        Route(int townA, int townB, int maintain) {
            this.townA = townA;
            this.townB = townB;
            this.maintain = maintain;
        }

        @Override
        public int compareTo(Route route) {
            return this.maintain - route.maintain;
        }
    }
}
