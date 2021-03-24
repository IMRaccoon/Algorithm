// 9 Score
package level_1;
import java.util.Scanner;

public class Solve_1 {
	public static void main(String [] args) {
		Solve_1 slv = new Solve_1();
	}
	private Solve_1() {
		Scanner scan = new Scanner(System.in);
		int month, day, flag;
		System.out.println("2016년의 a월 b일의 a, b를 입력하면 요일을 알려줍니다.\n 입력하세요.");
		month = scan.nextInt();
		day = scan.nextInt();
		flag = solution(1, month) + day;
		flag %= 7;
		switch(flag) {
			case 0: System.out.println("THU"); break;
			case 1: System.out.println("FRI"); break;
			case 2: System.out.println("SAT"); break;
			case 3: System.out.println("SUN"); break;
			case 4: System.out.println("MON"); break;
			case 5: System.out.println("TUE"); break;
			case 6: System.out.println("WED"); break;
		}
	}
	public int solution(int a, int b) {
			if(a < b) {
			if(a == 2)									// 2월은 예외 (29일)
				return solution(a+1, b) + 1;
			else if(a <= 7) {							// 1월부터 7월까지 규칙적
				if(a%2 == 0) 
					return solution(a+1, b) + 2;
				else
					return solution(a+1, b) + 3;
			}
			else {							// 8월부터 12월까지 규칙적
				if(a%2 == 0) 
					return solution(a+1, b) + 3;
				else
					return solution(a+1, b) + 2;
			}
		}
		return 0;
	}
}
