//4 Score
package Kakao_2018;

import java.util.LinkedList;

public class Cache {
    public static void main(String[] args) {
        Cache ch = new Cache();
    }
    public Cache() {
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"}));
        System.out.println(solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"}));
        System.out.println(solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
        System.out.println(solution(0, new String[]{"Jeju", "Jeju", "Jeju", "NewYork", "LA"}));
    }
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toLowerCase();
            if(list.contains(cities[i])) {
                list.removeFirstOccurrence(cities[i]);
                list.addLast(cities[i]);
                answer += 1;
            }
            else if(list.size() < cacheSize) {
                list.addLast(cities[i]);
                answer+=5;
            }
            else if(list.size() != 0){
                list.removeFirst();
                list.addLast(cities[i]);
                answer+=5;
            }
            else
                answer += 5;
        }
        return answer;
    }
}
