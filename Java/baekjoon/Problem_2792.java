import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int children = Integer.parseInt(st.nextToken());
        int colors = Integer.parseInt(st.nextToken());

        int [] jewels = new int[colors];
        long totalJewels = 0;
        long expectedMinJewels;
        long expectedMaxJewels = 0;

        for(int i = 0 ; i < colors; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            totalJewels += jewels[i];
            expectedMaxJewels = Math.max(jewels[i], expectedMaxJewels);
        }

        expectedMinJewels = Math.floorDiv(totalJewels, children);

        while(expectedMinJewels < expectedMaxJewels) {
            long expectedMidJewels = Math.floorDiv((expectedMaxJewels + expectedMinJewels), 2);
            if((expectedMaxJewels + expectedMinJewels) % 2 != 0) {
                expectedMidJewels += 1;
            }

            int tempChildren = 0;
            for(int i = 0; i < colors; i++) {
                tempChildren += Math.floorDiv(jewels[i], expectedMidJewels);
                if(jewels[i] % expectedMidJewels != 0) {
                    tempChildren += 1;
                }
            }

            if(expectedMidJewels == expectedMinJewels || expectedMidJewels == expectedMaxJewels) {
                expectedMinJewels = expectedMidJewels;
            }
            else if(tempChildren <= children) {
                expectedMaxJewels = expectedMidJewels;
            } else {
                expectedMinJewels = expectedMidJewels;
            }
        }

        System.out.println(expectedMinJewels);
    }
}
