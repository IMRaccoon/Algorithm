import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Problem_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        ArrayList<String> arr = new ArrayList<>(set);
        Collections.sort(arr, new MyComparator());
        for(String a : arr) {
            System.out.println(a);
        }
    }

    static class MyComparator implements Comparator<String> {
        @Override
        public int compare(String s, String t1) {
            if(s.length() > t1.length()) {
                return 1;
            } else if(s.length() < t1.length()) {
                return -1;
            }
            return s.compareTo(t1);
        }
    }
}
