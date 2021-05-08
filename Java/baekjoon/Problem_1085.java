import java.util.Scanner;
        import java.util.StringTokenizer;

public class Problem_1085 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(scan.nextLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int col = Math.min(Math.abs(x - w), x);
        int row = Math.min(Math.abs(y - h), y);
        System.out.println(Math.min(col, row));
    }
}
