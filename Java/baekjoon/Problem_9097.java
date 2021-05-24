import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_9097 {
    static StringBuilder binary;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int cases = Integer.parseInt(br.readLine());
        int n;
        boolean [][] map;

        for(int c = 0 ; c < cases; c++) {
            binary = new StringBuilder("");
            n = Integer.parseInt(br.readLine());
            map = new boolean[n][n];

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken().equals("0");
                }
            }

            Queue<Pair> array = new ArrayDeque<>();
            array.add(new Pair(0, 0, n, n));

            while(!array.isEmpty()) {
                Pair cur = array.poll();
                boolean target = map[cur.startX][cur.startY];
                boolean isTrue = true;

                for(int i = cur.startX; i < cur.endX; i++) {
                    if(!isTrue) break;
                    for(int j = cur.startY; j < cur.endY; j++) {
                        if(target != map[i][j]) {
                            isTrue = false;
                            break;
                        }
                    }
                }
                if(isTrue) {
                    binary.append("0").append(target ? "0" : "1");
                } else {
                    binary.append("1");
                    int mid = (cur.endX - cur.startX) / 2;
                    array.add(new Pair(cur.startX, cur.startY, cur.endX - mid, cur.endY - mid));
                    array.add(new Pair(cur.startX, cur.startY + mid, cur.endX - mid, cur.endY));
                    array.add(new Pair(cur.startX + mid, cur.startY, cur.endX, cur.endY - mid));
                    array.add(new Pair(cur.startX + mid, cur.startY + mid, cur.endX, cur.endY));
                }
            }

            bw.write(Integer.toString(Integer.parseInt(binary.toString(), 2), 16).toUpperCase());
            bw.newLine();
        }
        bw.flush();
    }

    private static class Pair{
        int startX;
        int startY;
        int endX;
        int endY;

        Pair(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }
}
