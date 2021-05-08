// 1 Score
package dynamic_programming;

public class Integer_Triangle {
    public static void main(String[] args) {
        Integer_Triangle IT = new Integer_Triangle();
    }
    public Integer_Triangle() {
        System.out.println(solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}));
    }
    public int solution(int [][] triangle) {
        int length = triangle.length;
        for(int i = length -2 ; i >= 0 ; i--) {
            for(int j = i; j >= 0; j--) {
                triangle[i][j] += triangle[i+1][j] > triangle[i+1][j+1] ? triangle[i+1][j] : triangle[i+1][j+1];
            }
        }
        return triangle[0][0];
    }

}
