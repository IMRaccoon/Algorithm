// 4 Score
package heap;

public class Ramen_Factory {
    public static void main(String[] args) {
        Ramen_Factory RF = new Ramen_Factory();
    }

    private Ramen_Factory() {
        //System.out.println(solution(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
        System.out.println(solution(6, new int[]{2, 3, 6, 17}, new int[]{3, 3, 5, 13}, 30));
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int possibleDay = stock;
        int answer = 0;
        int maxSupply = 0;
        int maxDay = -1;
        int tmp;
        while (possibleDay < k) {
            for (tmp = 0; tmp < dates.length; tmp++) {
                if (dates[tmp] > possibleDay) break;
                if (maxSupply < supplies[tmp]) {
                    maxSupply = supplies[tmp];
                    maxDay = tmp;
                }
            }
            possibleDay += maxSupply;
            if (maxSupply == 0) {
                maxDay = -1;
            } else {
                supplies[maxDay] = 0;
                maxSupply = 0;
                answer += 1;
            }
        }
        return answer;
    }
}