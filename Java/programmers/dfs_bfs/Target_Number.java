package dfs_bfs;
// 1 Score
public class Target_Number {
    public static void main(String[] args) {
        Target_Number TN = new Target_Number();
    }
    private Target_Number() {
        System.out.println(solution(new int[]{1,1,1,1,1}, 3));
    }
    static int answer;
    public int solution(int[] numbers, int target) {
        recursive(numbers, 0, 0, target);
        return answer;
    }
    private void recursive(int [] numbers, int index, int compare, int target) {
        if(index == numbers.length) {
            if(compare == target) answer += 1;
        }
        else {
            compare += numbers[index];
            recursive(numbers, index+1, compare, target);
            compare -= numbers[index] * 2;
            recursive(numbers, index+1, compare, target);
        }
    }
}