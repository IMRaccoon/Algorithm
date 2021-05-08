// 2 Score
package hash;

import java.util.HashMap;

public class List_Numbers {
    public static void main(String[] args) {
        List_Numbers LN = new List_Numbers();
    }
    private List_Numbers() {
        System.out.println(solution(new String[]{"119", "11091197674223", "112"}));
        //System.out.println(solution(new String[]{"123","456","789"}));
        //System.out.println(solution(new String[]{"12","123","1235","567","88"}));
        //System.out.println(solution(new String[]{"123"}));
    }
    public boolean solution(String[] phone_book) {
        HashMap<Integer, String> hash = new HashMap<>();
        int size = 0;
        for(String a : phone_book) {
            for(int i = 0 ; i< size; i++) {
                String b = hash.get(i);
                if(b.compareTo(a) >= 0 && b.contains(a))
                    return false;
                else if(a.compareTo(b) >= 0 && a.contains(b))
                    return false;
            }
            hash.put(size, a);
            size ++;
        }
        return true;
    }
}
