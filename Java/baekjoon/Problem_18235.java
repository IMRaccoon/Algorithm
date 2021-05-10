import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Problem_18235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]), a = Integer.parseInt(inputs[1]), b = Integer.parseInt(inputs[2]);

        int [] map = new int[n+1];
        ArrayDeque<Integer> aPos = new ArrayDeque<>();
        ArrayDeque<Integer> bPos = new ArrayDeque<>();

        aPos.add(a);
        bPos.add(b);

        int size;
        int counter = 0;
        int move;
        while(!aPos.isEmpty() && !bPos.isEmpty()) {
            move = (int)Math.pow(2, counter);
            counter += 1;
            if(move > n) {
                System.out.println(-1);
                return;
            }

            size = aPos.size();
            for(int i = 0 ; i < size; i++) {
                int cur = aPos.poll();
                if(cur + move <= n) {
                    map[move + cur] = counter;
                    aPos.add(move + cur);
                }
                if(cur - move > 0) {
                    map[cur - move] = counter;
                    aPos.add(cur - move);
                }
            }

            size = bPos.size();
            for(int i = 0 ; i < size; i++) {
                int cur = bPos.poll();
                if(cur + move <= n) {
                    if(map[move + cur] == counter) {
                        System.out.println(counter);
                        return;
                    }
                    bPos.add(move + cur);
                }
                if(cur - move > 0) {
                    if(map[cur - move] == counter) {
                        System.out.println(counter);
                        return;
                    }
                    bPos.add(cur - move);
                }
            }
        }
        System.out.println(-1);
    }
}
