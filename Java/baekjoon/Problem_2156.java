import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2156 {
    static int [] glasses;
    static int [] sum;
    static int glassNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        glassNumber = Integer.parseInt(br.readLine());
        glasses = new int[glassNumber + 3];
        sum = new int[glassNumber + 3];

        for(int i = 3; i < glassNumber + 3; i++) {
            glasses[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 3; i < glassNumber + 3; i++) {
            sum[i] = customMax(sum[i-2] + glasses[i], sum[i-3] + glasses[i-1] + glasses[i], sum[i-1]);
        }

        System.out.println(sum[glassNumber + 2]);
    }



    public static int customMax(int a, int b, int c) {
        return Math.max(c, Math.max(a, b));
    }

}
