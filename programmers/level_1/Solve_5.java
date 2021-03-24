// 5 Score
package level_1;

public class Solve_5 {
	public static void main(String [] args) {
		Solve_5 sol = new Solve_5();
	}
	public Solve_5() {
		System.out.println(solution(3,5));
		System.out.println(solution(3,3));
		System.out.println(solution(5,3));
	}
	public long solution(int a, int b) {
		long answer = 0;
		if(a > b) {
			int flag = a;
			a = b;
			b = flag;
		}
		
		for(; a<=b; a++) {
			answer += a;
		}
		return answer;
	}
}
