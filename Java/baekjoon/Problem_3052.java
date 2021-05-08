import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Problem_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        TreeSet treeSet = new TreeSet<Integer>();
        for(int i = 0 ; i < 10; i++) {
            treeSet.add(Integer.parseInt(br.readLine()) % 42);
        }
        System.out.println(treeSet.size());
    }
}
