import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_16928 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int [] board = new int[101];
        int [] visited = new int[101];
        Arrays.fill(visited, 100);
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0 ; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visited[1] = 0;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == 100) break;

            for(int i = 1; i <= 6; i++) {
                if(cur + i > 100) break;
                if(board[cur + i] != 0 && visited[board[cur + i]] > visited[cur] + 1) {
                    q.offer(board[cur + i]);
                    visited[board[cur + i]] = visited[cur] + 1;
                }
            }
            for(int i = 6; i >= 1; i --) {
                if(cur + i > 100) continue;
                if(board[cur + i] == 0 && visited[cur + i] > visited[cur] + 1) {
                    visited[cur + i] = visited[cur] + 1;
                    q.offer(cur + i);
                    break;
                }
            }

        }
        System.out.println(visited[100]);
    }
}
