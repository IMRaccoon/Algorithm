package Skill_Check;

public class level2_problem1 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    public static int solution(int n) {
        int answer = 0;
        int sum = 1;
        int count = 1;
        while(n >= sum) {
            if((n-sum) % (count) == 0){
                System.out.println(count);
                answer += 1;
            }
            count += 1;
            sum += count;
        }
        return answer;
    }
}
