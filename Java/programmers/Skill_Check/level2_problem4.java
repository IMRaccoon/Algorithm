package Skill_Check;

public class level2_problem4 {
    public static void main(String[] args) {
        level2_problem4 lp4 = new level2_problem4();
    }
    level2_problem4() {
        System.out.println(solution(4, new int[]{4, 10, 15}, new int[] {20, 5, 10}, 30));
    }
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int length = dates.length;
        int patient = stock;
        int lastIndex = 0;
        int isBest = 0;
        while(patient <= k-1) {
            for (int i = lastIndex; i < length; i++) {
                if (dates[i] <= patient) {
                    if (isBest < supplies[i]) {
                        isBest = supplies[i];
                        lastIndex = i;
                    }
                }
            }
            patient += isBest;
            lastIndex += 1;
            isBest = 0;
            answer += 1;
        }
        return answer;
    }
}
