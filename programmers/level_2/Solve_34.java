// 2 Score
package level_2;

public class Solve_34 {
    public static void main(String[] args) {
        Solve_34 sol = new Solve_34();
    }
    private Solve_34() {
        System.out.println(solution2(12));
    }
    public int solution(int n) {
        int i, j;
        String str = Integer.toString(n,2);
        char [] bin = new char[str.length() + 1];
        bin[0] = '0';
        int length = str.length();
        for(i=0; i<length; i++) {
            bin[i+1] = str.charAt(i);
        }
        while(true) {
            if(bin[i] == '1' && i == length) {
                for(j = i; bin[j] != '0'; j--);
                bin[j+1] = '0';
                bin[j] = '1';
                break;
            }
            else if(bin[i] == '1' && i != length) {
                int a = 0;
                for(j = i; bin[j] != '0'; j--);
                bin[j+1] = '0';
                bin[j] = '1';
                for(j += 2; j< (length + j + 1)/2; j++) {
                    i = bin[j];
                    bin[j] = bin[length - a];
                    bin[length - a] = (char)i;
                    a++;
                }
                break;
            }
            else if(bin[i] == '1' && i == 0)
                return n*2;
            else if(bin[i] == '0')
                i--;
            else
                break;
        }
        return Integer.valueOf(String.valueOf(bin), 2);
    }
    public int solution2(int n) {
        int postPattern = n & -n, smallPattern = ((n ^ (n + postPattern)) / postPattern) >> 2;
        return n + postPattern | smallPattern;
    }
}
