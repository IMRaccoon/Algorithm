package dynamic_programming;


public class Thievery {
    public static void main(String[] args) {
        Thievery t = new Thievery();
        System.out.println(t.solution(new int[]{1, 2, 3, 1}));
        System.out.println(t.solution(new int[]{1, 1, 1, 5, 6, 5}));
        System.out.println(t.solution(new int[]{3, 3, 3, 3, 3, 3, 3}));
    }

    // 첫번째꺼 무조건 포함하고 마지막 이전까지
    // 첫번째꺼 무시하고 마지막꺼를 포함하는 경우
    // 첫번째꺼 마지막꺼 안넣는 경우
    public int solution(int[] money) {
        int [][] acc = new int[money.length][4];
        acc[1][1] = money[0];
        acc[1][2] = money[1];

        for(int i = 2; i < money.length; i++) {
            acc[i][0] = acc[i - 1][1] + money[i];
            acc[i][1] = Math.max(acc[i - 1][0], acc[i - 1][1]);
            acc[i][2] = acc[i - 1][3] + money[i];
            acc[i][3] = Math.max(acc[i - 1][2], acc[i - 1][3]);
        }
        return Math.max(Math.max(acc[money.length - 2][0], acc[money.length - 1][1]), Math.max(acc[money.length - 1][2], acc[money.length - 1][3]));
    }
}
