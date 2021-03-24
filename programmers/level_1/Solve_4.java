// 4 Score
package level_1;

public class Solve_4 {
	public static void main(String [] args) {
		Solve_4 sol = new Solve_4();
	}
	public Solve_4() {
		int [] arr = new int[] {1,4,2,8,7,3};
		solution(arr, 2);
	}
	static int num = 0;
	public int[] solution(int [] arr, int divisor) {
		int [] answer = null;
		int i, j, flag;
		for(i =0; i< arr.length-1; i++) {
			for(j = i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					flag = arr[i];
					arr[i] = arr[j];
					arr[j] = flag;
				}
			}
		}
		for(i =0; i<arr.length; i++) {
			if((arr[i] % divisor) == 0)
				num += 1;
			else
				arr[i] = -1;
		}
		if(num == 0)
			answer = new int[] {-1};
		else {
			answer = new int[num];
			for(i=0, j=0; j<arr.length; j++) {
				if(arr[j] != -1) {
					answer[i] = arr[j]; 
					i += 1;
				}
			}
		}
		for(int value : answer)
			System.out.println(value);
		return answer;
	}
}
