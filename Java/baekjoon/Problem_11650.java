import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Problem_11650 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        ArrayList<Pos> arr = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        arr.sort(new MyComparator());

        for(Pos p: arr) {
            bw.write(p.x + " " + p.y+ "\n");
        }
        bw.flush();

    }

    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class MyComparator implements Comparator<Pos> {
        @Override
        public int compare(Pos pos, Pos t1) {
            if(pos.x == t1.x) {
                return pos.y - t1.y;
            }
            return pos.x - t1.x;
        }
    }
}
