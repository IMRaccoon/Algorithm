// 1 Score
package find_programming_maestro;
import java.util.Arrays;

public class PhoneKetmon {
    public static void main(String[] args) {
        PhoneKetmon PK = new PhoneKetmon();
    }
    private PhoneKetmon() {
        System.out.println(solution(new int[]{3, 1, 2, 3}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 4}));
        System.out.println(solution(new int[]{3, 3, 3, 2, 2, 2}));
    }
    public int solution(int [] nums) {
        int answer = 1;
        Arrays.sort(nums);
        for(int i = 1 ; i<nums.length; i++) {
            if(nums[i] != nums[i-1])
                answer += 1;
        }
        return answer > nums.length/2 ? nums.length/2 : answer;
    }
}
