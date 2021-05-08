// 9 Score
package level_1;

import java.util.Scanner;

public class Solve_3 {
	public static void main(String [] args) {
		Solve_3 sol = new Solve_3();
	}
	public Solve_3() {
		Scanner scan = new Scanner(System.in);
		int [] arr = {1,1,1,3,3,1,1};
		solution(arr);
	}
	static int num = 0;
	static int num2 = 0;
	public int [] solution(int [] arr) {
		int [] answer = null;
		for(int i = 0; i < arr.length-1; i++) {
			if(arr[i] == arr[i+1]) {
				arr[i] = 10;							// ���ǵ� �迭 ���� ���� 0~9���� �̹Ƿ� 10�� ǥ���� �� �ߺ��� �������� �����ֱ� ���� ����
			}
			else if(arr[i] != arr[i+1]) {
				num += 1;
			}
		}
		num += 1;										// �����ϴ� ���ڰ� ���Ե��� ������ Ŀ��
		answer = new int[num];
		for(int i = 0; i<arr.length; i++) {
			if(arr[i] != 10) {
				answer[num2] = arr[i];
				num2 += 1;
			}
		}
		for(int value:answer)
			System.out.println(value);
		return answer;
	}
}
