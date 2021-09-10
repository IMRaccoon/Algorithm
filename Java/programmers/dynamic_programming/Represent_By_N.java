package dynamic_programming;


import java.util.ArrayList;

public class Represent_By_N {
    public static void main(String[] args) {
        Represent_By_N RN = new Represent_By_N();
    }
    private Represent_By_N() {
        System.out.println(solution(5, 12));
        System.out.println(solution(2, 11));
    }

    int MAX = 1_000_000_000;
    public int solution(int N, int number) {
        boolean [] visited = new boolean[MAX];
        int acc = 0;
        ArrayList<Integer>[] list = new ArrayList[9];
        for(int i = 1; i <= 8; i++) {
            acc = (acc * 10) + N;
            list[i] = new ArrayList<>();
            list[i].add(acc);
            if(acc == number) return i;
            visited[acc] = true;
        }

        for(int i = 2; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int first : list[j]) {
                    for (int second : list[i - j]) {
                        int res = first + second;
                        if (!visited[res]) {
                            if(res == number) return i;
                            visited[res] = true;
                            list[i].add(res);
                        }

                        res = first - second;
                        if (res > 0 && !visited[res]) {
                            if(res == number) return i;
                            visited[res] = true;
                            list[i].add(res);
                        }

                        res = first * second;
                        if (!visited[res]) {
                            if(res == number) return i;
                            visited[res] = true;
                            list[i].add(res);
                        }

                        res = Math.floorDiv(first, second);
                        if (res > 0 && !visited[res]) {
                            if(res == number) return i;
                            visited[res] = true;
                            list[i].add(res);
                        }
                    }
                }
            }
        }
        return -1;
    }
}
