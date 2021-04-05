import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.StringTokenizer;

public class Problem_9177 {
    static char[] first;
    static char[] second;
    static char[] mixed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());


        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            first = st.nextToken().toCharArray();
            second = st.nextToken().toCharArray();
            mixed = st.nextToken().toCharArray();
            if (checkAll() && dp(0, 0, 0)) {
                System.out.println("Data set " + i + ": yes");
            } else {
                System.out.println("Data set " + i + ": no");
            }
        }
    }


    static boolean dp(int firstIndex, int secondIndex, int thirdIndex) {
        if (thirdIndex == mixed.length) {
            return true;
        }

        boolean check = false;
        if (firstIndex != first.length && first[firstIndex] == mixed[thirdIndex]) {
            check = dp(firstIndex + 1, secondIndex, thirdIndex + 1);
        }
        if (!check && secondIndex != second.length && second[secondIndex] == mixed[thirdIndex]) {
            check = dp(firstIndex, secondIndex + 1, thirdIndex + 1);
        }
        return check;
    }

    static boolean checkAll() {
        int[] arr = new int[52];
        for (int i = 0; i < first.length; i++) {
            if (Character.isLowerCase(first[i])) {
                arr[first[i] - 'a']++;
            } else {
                arr[first[i] - 'A' + 26]++;
            }
        }
        for (int i = 0; i < second.length; i++) {
            if (Character.isLowerCase(second[i])) {
                arr[second[i] - 'a']++;
            } else {
                arr[second[i] - 'A' + 26]++;
            }
        }
        for (int i = 0; i < mixed.length; i++) {
            if (Character.isLowerCase(mixed[i])) {
                arr[mixed[i] - 'a']--;
            } else {
                arr[mixed[i] - 'A' + 26]--;
            }
        }
        for (int i = 0; i < 52; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
