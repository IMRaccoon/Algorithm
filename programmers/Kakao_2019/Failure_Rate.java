// 3 Score
package Kakao_2019;

import java.util.*;

public class Failure_Rate {
    public static void main(String[] args) {
        Failure_Rate FR = new Failure_Rate();
    }
    private Failure_Rate() {
        System.out.println(Arrays.toString(solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})));
        System.out.println(Arrays.toString(solution(4, new int[]{4, 4, 4, 4, 3})));
        System.out.println(Arrays.toString(solution(5, new int[]{3, 3, 4, 5, 6, 6, 6, 6})));
    }
    public int[] solution(int N, int [] stages) {
        List<Integer> list = new ArrayList<>();
        HashMap<Integer, Float> hash = new HashMap<>();
        int people = stages.length;
        for(int i = 1 ; i<= N+1; i++)
            hash.put(i, 0f);
        for(int stage : stages) {
            float tmp = hash.get(stage)+1;
            hash.replace(stage, tmp);
        }
        for(int i = 1; i<= N; i++) {
            float tmp = hash.get(i);
            if(people != 0)
                hash.replace(i, tmp/people);
            list.add(i);
            people-=tmp;
        }
        Collections.sort(list, (o1, o2) -> {
            Float v1 = hash.get(o1);
            Float v2 = hash.get(o2);
            return (v2).compareTo(v1);
        });
        return list.stream().mapToInt(value -> value).toArray();
    }
}
