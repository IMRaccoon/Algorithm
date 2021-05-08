package level_3;

public class Change {
    public static void main(String[] args) {
        Change C = new Change();
    }
    private Change() {
        int [] a = new int[100];
        for(int i = 1; i<=100; i++) a[i-1] = i;
        //System.out.println(solution(5, new int[] {1,2,5}));
        System.out.println(solution(100000, a));
    }
    private int[] money;
    private long answer;
    public int solution(int n, int [] money) {
        answer = 0;
        this.money = money;
        recursive(n, money.length-1);
        return (int)answer%1000000007;
    }
    public void recursive(int total, int index) {
        if(total != 0 && total % money[index] == 0) answer ++;
        if(index == 0 || total == 0) return;
        for(int i = (total / (money[index])); i >= 0; i--)
            recursive(total - (money[index] * i), index-1);
    }
}
