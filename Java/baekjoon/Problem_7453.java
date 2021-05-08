import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.Arrays;
        import java.util.StringTokenizer;

public class Problem_7453 {
    static int [] firstArr;
    static int [] secondArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int num = Integer.parseInt(br.readLine());

        int [][] arr = new int[num][4];

        for(int i = 0 ; i < num; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        firstArr = new int[num * num];
        secondArr = new int[num * num];

        for(int i = 0 ; i < num; i++) {
            for(int j = 0 ; j< num ; j++) {
                firstArr[(num * i) + j] = arr[i][0] + arr[j][1];
                secondArr[(num * i) + j] = arr[i][2] + arr[j][3];
            }
        }

        Arrays.sort(firstArr);
        Arrays.sort(secondArr);

        long counter = 0;
        int range = num * num;

        int secondIndex = range - 1;

        for(int firstIndex = 0 ; firstIndex < range;) {
            long firstCount = countFromFront(firstIndex, range, firstArr);

            for(; secondIndex >= 0;) {

                long secondCount = countFromBack(secondIndex, secondArr);
                if(firstArr[firstIndex] + secondArr[secondIndex] < 0) {
                    break;
                } else if(firstArr[firstIndex] + secondArr[secondIndex] == 0) {
                    counter += (firstCount * secondCount);
                }
                secondIndex -= secondCount;
            }
            firstIndex += firstCount;
        }

        System.out.println(counter);
    }
    public static long countFromBack(int start, int [] target) {
        int counter = 1;
        for(; start - counter >= 0; counter ++) {
            if(target[start] > target[start - counter])  {
                return counter;
            }
        }
        return counter;
    }

    public static long countFromFront(int start, int end, int[] target) {
        int counter = 1;
        for(; start + counter < end; counter ++) {
            if(target[start] < target[start + counter]) {
                return counter;
            }
        }
        return counter;
    }
}
