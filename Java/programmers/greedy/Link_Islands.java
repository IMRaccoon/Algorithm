package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Link_Islands {
    public static void main(String[] args) {
        Link_Islands li = new Link_Islands();
//        System.out.println(li.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
        System.out.println(li.solution(5, new int[][]{{0, 1, 5}, {1, 2, 3}, {2, 3, 3}, {3, 1, 2}, {3, 0, 4}, {2, 4, 6}, {4, 0, 7}}));
    }

    int [] linked;
    public int solution(int n, int[][] costs) {
        int answer = 0;
        linked = new int[n];
        Arrays.fill(linked, -1);
        Arrays.sort(costs, Comparator.comparingInt(c -> c[2]));
        int first, second, price, firstRoot, secondRoot;
        for (int[] cost : costs) {
            System.out.println(Arrays.toString(cost));
            first = Math.min(cost[0], cost[1]);
            second = Math.max(cost[0], cost[1]);
            price = cost[2];

            if (linked[first] == -1 && linked[second] == -1) {
                linked[first] = linked[second] = first;
                answer += price;
            } else if (linked[first] == -1) {
                secondRoot = findRoot(second);
                linked[first] = linked[secondRoot] = Math.min(first, secondRoot);
                answer += price;
            } else if(linked[second] == -1) {
                firstRoot = findRoot(first);
                linked[firstRoot] = linked[second] = Math.min(second, firstRoot);
                answer += price;
            } else {
                firstRoot = findRoot(first);
                secondRoot = findRoot(second);
                if (firstRoot != secondRoot) {
                    linked[firstRoot] = linked[secondRoot] = Math.min(firstRoot, secondRoot);
                    answer += price;
                }
            }
        }
        return answer;
    }

    private int findRoot(int cur) {
        if(cur == linked[cur]) return cur;
        return findRoot(linked[cur]);
    }
}
