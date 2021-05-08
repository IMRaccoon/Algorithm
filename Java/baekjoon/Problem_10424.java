import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_10424 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int [] midTern = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            // 기말고사 성적순, 중간 성적
            int midScore = Integer.parseInt(st.nextToken());
            midTern[midScore - 1]  = midScore - i;
        }

        for(int satisfied : midTern) {
            System.out.println(satisfied);
        }
    }
}