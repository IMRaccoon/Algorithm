// 2 Score
package hash;

import java.util.HashMap;
import java.util.LinkedList;

public class Camouflage {
    public static void main(String[] args) {
        Camouflage C = new Camouflage();
    }
    private Camouflage() {
        System.out.println(solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
        System.out.println(solution(new String[][]{{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}}));
    }
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> hash = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        for(String [] a : clothes) {
            if(hash.containsKey(a[1]))
                hash.replace(a[1], hash.get(a[1])+1);
            else {
                hash.put(a[1], 1);
                list.add(a[1]);
            }
        }
        while(!list.isEmpty())
            answer *= (hash.get(list.pop()) + 1);
        return answer -1;
    }
}
