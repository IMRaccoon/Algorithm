package Skill_Check;

public class level2_problem6 {
    public static void main(String[] args) {
        level2_problem6 level2_problem6 = new level2_problem6();
    }
    private level2_problem6() {
        System.out.println(solution(new int[] {1,1,1,1,1}, 3));
    }
    private int solution(int [] numbers, int target) {
        return recursive(numbers, 0, target, 0);
    }
    private int recursive(int [] numbers, int index, int target, int tmp) {
        if(index == numbers.length) {
            if(tmp == target) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else {
            return recursive(numbers, index+1, target, tmp+numbers[index]) + recursive(numbers, index+1, target, tmp-numbers[index]);
        }
    }
}
