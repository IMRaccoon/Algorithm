import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Problem_2038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if(N == 1) {
            System.out.println(1);
            return;
        }

        ArrayList<Pair> arr = new ArrayList<>();
        arr.add(new Pair(1, 1));
        arr.add(new Pair(3, 2));
        int index = 1, length = 3;
        Pair p = arr.get(index);
        for(int cur = 3; length < N; cur ++) {
            if (cur > p.to) {
                index += 1;
                p = arr.get(index);
            }
            length += p.num;
            arr.add(new Pair(length, cur));
        }
        System.out.println(arr.get(arr.size() - 1).num);
    }

    private static class Pair{
        int to;
        int num;

        Pair(int to, int num) {
            this.to = to;
            this.num = num;
        }
    }
}
// 1 2 2 3 3 4 4 4 5 5
// 5 6 6 6 6 7 7 7 7 8
// 8 8 8 9 9 9 9 9 10 10
// 10 10 10 11 11 11 11 11 12 12
// 12 12 12 12 13 13 13 13 13 13