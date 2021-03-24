// 4 Score
package level_1;
import java.util.Scanner;

public class Solve_2 {
	public static void main(String [] args) {
		Solve_2 solution = new Solve_2();
	}
	public Solve_2() {
		String s = null;
		int a = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("���ڿ��� �Է��ϼ��� : ");
		s = scan.nextLine();
		a = s.length() - 1;
		if(a % 2 == 0)
			System.out.println(s.substring(a/2, (a/2)+1));					// substring(startAddress, endAddress)
		else
			System.out.println(s.substring((a-1)/2,(a+1)/2+1));				// return String type, except endAddress character.
	}
}
