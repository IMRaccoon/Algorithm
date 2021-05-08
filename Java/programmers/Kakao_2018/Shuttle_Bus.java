// 6 Socre
package Kakao_2018;

import java.util.Arrays;
import java.util.LinkedList;

public class Shuttle_Bus {
    public static void main(String[] args) {
        Shuttle_Bus SB = new Shuttle_Bus();
    }
    private Shuttle_Bus() {
        System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03", "08:04", "08:05"}));
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        //System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        //System.out.println(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        //System.out.println(solution(1, 1, 1, new String[]{"23:59"}));
        //System.out.println(solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
    }
    public String solution(int n, int t, int m, String[] timetable) {
        Arrays.sort(timetable);
        LinkedList<Integer> person = new LinkedList<>();
        LinkedList<Integer> bus = new LinkedList<>();
        int tmp = 0, length = timetable.length, lastBus, lastPerson = 0;
        for(int i = 0 ; i<length; i++)
            person.add(Integer.parseInt(timetable[i].substring(0,2)) * 100 + Integer.parseInt(timetable[i].substring(3,5)));
        for(int i = 0; i< n * m; i++) {
            if(i % m == 0 && i != 0)
                tmp = add(tmp, t);
            bus.add(900 + tmp);
        }
        lastBus = bus.getLast();
        for(int i = 0 ; i < length; i++) {
            int j = 0;
            while(j != bus.size()){
                if(bus.get(j) >= person.get(i)) {
                    lastPerson = person.get(i);
                    bus.remove(j);
                    break;
                }
                else
                    j++;
            }
        }
        if(bus.contains(lastBus))
            return String.format("%02d:%02d",Math.floorDiv(lastBus,100),lastBus%100);
        else {
            lastBus = sub(lastPerson, 1);
            return String.format("%02d:%02d", Math.floorDiv(lastBus, 100), lastBus % 100);
        }
    }
    public int add(int a, int b) {
        if (a % 100 + b >= 60)
            return a+b+40;
        else return a+b;
    }
    public int sub(int a, int b) {
        if(a % 100 - b < 0)
            return a-b-40;
        else return a-b;
    }
}
