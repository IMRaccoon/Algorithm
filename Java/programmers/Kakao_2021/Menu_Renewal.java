package Kakao_2021;

import java.util.*;

public class Menu_Renewal {
    public static void main(String[] args) {
        Menu_Renewal m = new Menu_Renewal();

        System.out.println(Arrays.toString(m.solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        m.solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4});
        m.solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5});
    }


    int max = 0;
    HashMap<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        for (int c : course) {
            map = new HashMap<>();
            max = 0;

            for (String o : orders) {
                combination(0, "", 0, c, o);
            }
            for (String k : map.keySet()) {
                if (map.get(k) == max && max > 1) {
                    answer.add(k);
                }
            }
        }
        answer.sort(String::compareTo);

        return answer.toArray(new String[0]);
    }


    public void combination(int cur, String s, int idx, int count, String w) {
        if (cur == count) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String tmp = new String(arr);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            max = Math.max(max, map.get(tmp));
            return;
        }

        for (int i = idx; i < w.length(); i++) {
            combination(cur + 1, s + w.charAt(i), i + 1, count, w);
        }
    }
}
