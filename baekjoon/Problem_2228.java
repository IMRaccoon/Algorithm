import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2228 {
    static int number;
    static int interval;
    static int [] numberArray;
    static boolean [][] checkDict;
    static int [][] maxDict;
    static int [][] sumDict;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        number = Integer.parseInt(st.nextToken());
        interval = Integer.parseInt(st.nextToken());
        numberArray = new int[number];

        for(int i = 0 ; i < number; i++) {
            numberArray[i] = Integer.parseInt(br.readLine());
        }

        checkDict = new boolean[number][number];
        maxDict = new int[number][number];
        sumDict = new int[number][number];

        int endIndex = number - 1 - (2 * (interval - 1));
        int max = intervalLoop(0, endIndex, 1);


        System.out.println(max);
    }

    /**
     * 각 Interval Index 에 따라 해당 범위의 가장 큰값을 구하고
     * 다음 Interval Index 에서도 가장 큰 값을 받는다.
     * end 부터 start 순으로 진행된다.
     */
    public static int intervalLoop(int start, int end, int intervalIndex) {
        int max = 0;

        if(intervalIndex == interval) {
            if(!checkDict[start][end]) {
                for (int i = start; i <= end; i++) {
                    if (i == start) {
                        max = getMaxRangSum(i, end);
                    } else {
                        max = Math.max(max, getMaxRangSum(i, end));
                    }
                }
            }
            max = maxDict[start][end];

        } else {
            int nextEndIndex = number - 1 - (2 * (interval - intervalIndex - 1));
            for(int i = start; i <= end; i++) {
                int currentSum = getMaxRangSum(start, i);

                if(i == end + 2) {
                    max = currentSum + intervalLoop(i + 2, nextEndIndex, intervalIndex + 1);
                } else {
                    max = Math.max(max, currentSum + intervalLoop(i + 2, nextEndIndex, intervalIndex + 1));
                }
            }
        }

        return max;
    }


    /**
     * 시작점부터 끝점까지의 숫자배열중 최댓값
     */
    public static int getMaxRangSum(int start, int end) {
        if(checkDict[start][end]) {
            return maxDict[start][end];
        }

        for(int i = start; i <= end; i ++) {
            checkDict[start][i] = true;
            if(i == start) {
                sumDict[start][i] = numberArray[i];
                maxDict[start][i] = numberArray[i];
            } else {
                sumDict[start][i] = sumDict[start][i-1] + numberArray[i];
                maxDict[start][i] = Math.max(numberArray[i], Math.max(maxDict[start][i-1], sumDict[start][i]));
            }
        }
        return maxDict[start][end];
    }
}

