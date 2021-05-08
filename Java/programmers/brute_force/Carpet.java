// 1 Score
package brute_force;

import java.util.Arrays;

public class Carpet {
    public static void main(String[] args) {
        Carpet c = new Carpet();
    }
    private Carpet() {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }
    public int [] solution(int brown, int red) {
        int sum = brown + red;
        int redBig = (int)Math.sqrt(red);
        int redBig2;
        for(; redBig >= 1; redBig --) {
            if (red % redBig == 0) {
                redBig2 = red / redBig;
                for (int i = 1; ; i++) {
                    if (sum == (redBig + i) * (redBig2 + i)) {
                        return new int[]{Math.max(redBig+i, redBig2+i), Math.min(redBig+i, redBig2+i)};
                    } else if (sum < (redBig + i) * (redBig2 + i))
                        break;
                }
            }
        }
        return null;
    }

}