package Kakao_2021;

import java.util.ArrayList;

public class Minimize_Drop_Sale {
    public static void main(String[] args) {
        Minimize_Drop_Sale m = new Minimize_Drop_Sale();
        System.out.println(m.solution(new int[]{14, 17, 15, 18, 19, 14, 13, 16, 28, 17}, new int[][]{{10, 8}, {1, 9}, {9, 7}, {5, 4}, {1, 5}, {5, 10}, {10, 6}, {1, 3}, {10, 2}}));
    }

    ArrayList<Integer>[] child;
    int [][] dp;
    public int solution(int[] sales, int[][] links) {
        child = new ArrayList[sales.length + 1];
        dp = new int[sales.length + 1][2];
        for(int i = 0; i < sales.length; i++) {
            dp[i + 1][1] = sales[i];
        }

        for(int [] link : links) {
            if(child[link[0]] == null) child[link[0]] = new ArrayList<>();
            child[link[0]].add(link[1]);
        }

        recursive(1);
        return Math.min(dp[1][0], dp[1][1]);
    }

    public void recursive(int index) {
        if(child[index] == null) return;
        int tmp = Integer.MAX_VALUE;
        boolean tmpAdd = true;
        for(int c : child[index]) {
            recursive(c);
            if(dp[c][0] < dp[c][1]) {
                dp[index][1] += dp[c][0];
                dp[index][0] += dp[c][0];
                tmp = Math.min(tmp, dp[c][1] - dp[c][0]);
            } else {
                dp[index][1] += dp[c][1];
                dp[index][0] += dp[c][1];
                tmpAdd = false;
            }
        }
        if(tmpAdd) dp[index][0] += tmp;
    }
}
