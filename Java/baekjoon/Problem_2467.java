import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Problem_2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] liquid = new int[size];
        for (int i = 0; i < size; i++) {
            liquid[i] = Integer.parseInt(st.nextToken());
        }

        int firstIndex = 0;
        int lastIndex = size - 1;
        int sum = Integer.MAX_VALUE;
        int first = 0, last = 0, tmpSum;

        while(firstIndex != lastIndex) {
            tmpSum = liquid[firstIndex] + liquid[lastIndex];
            if(Math.abs(tmpSum) < sum) {
                sum = Math.abs(tmpSum);
                first = liquid[firstIndex];
                last = liquid[lastIndex];
            }
            if(tmpSum > 0) {
                lastIndex -= 1;
            } else if(tmpSum < 0) {
                firstIndex += 1;
            } else break;
        }

        System.out.println(first + " " + last);
    }
}
