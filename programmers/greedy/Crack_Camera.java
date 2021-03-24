// 3 Score
package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class Crack_Camera {
    public static void main(String[] args) {
        Crack_Camera CC = new Crack_Camera();
    }
    private Crack_Camera() {
        System.out.println(solution(new int[][]{{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}}));
    }
    public int solution(int [][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count = 1, length = routes.length;
        int current = routes[0][1];
        for(int i = 0  ; i<length; i++) {
            if(routes[i][0] > current) {
                count += 1;
                current = routes[i][1];
            }
        }
        return count;
    }
}
