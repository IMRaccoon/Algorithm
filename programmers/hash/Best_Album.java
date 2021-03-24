// 4 Score
package hash;

import java.util.*;

public class Best_Album {
    public static void main(String[] args) {
        Best_Album BA = new Best_Album();
    }

    public Best_Album() {
        System.out.println(Arrays.toString(solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 800, 2500})));
    }
    public int[] solution(String[] genres, int[] plays) {
        int length = plays.length;
        Queue<Integer> answer = new ArrayDeque<>();
        HashMap<String, Integer> forSort = new HashMap<>();
        for(int i = 0 ; i<length; i++) {
            if(forSort.get(genres[i]) == null)
                forSort.put(genres[i], plays[i]);
            else forSort.replace(genres[i], forSort.get(genres[i])+plays[i]);
        }
        List<String> list = sortByValue(forSort);
        length = list.size();
        for(int i =0  ; i<length; i++) {
            int [] biggest = new int[2];
            int [] second = new int[2];
            String compare = list.remove(0);
            for(int j = 0 ; j< plays.length; j++) {
                if(compare.equals(genres[j])) {
                    if(biggest[0] < plays[j]) {
                        second[0] = biggest[0];
                        second[1] = biggest[1];
                        biggest[0] = plays[j];
                        biggest[1] = j;
                    }
                    else if(second[0] < plays[j]) {
                        second[0] = plays[j];
                        second[1] = j;
                    }
                }
            }
            answer.offer(biggest[1]);
            if(second[0] != 0) answer.offer(second[1]);
        }
        int [] returnValue = new int[answer.size()];
        length = answer.size();
        for(int i = 0; i < length; i++)
            returnValue[i] = answer.remove();
        return returnValue;
    }
    public static List sortByValue(final Map map) {         // 만약 같을 경우 개수가 많은 것부터 출력 인거 확인
        List<String> list = new ArrayList();
        list.addAll(map.keySet());
        Collections.sort(list, (Comparator) (o1, o2) -> {
            Object v1 = map.get(o1);
            Object v2 = map.get(o2);
            return ((Comparable) v2).compareTo(v1);
        });
        return list;
    }
}