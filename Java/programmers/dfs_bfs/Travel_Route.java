package dfs_bfs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Travel_Route {
    public static void main(String[] args) {
        Travel_Route t = new Travel_Route();

        String[][][] exam = {
                {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}},
                {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}},
                {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}},
                {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}},
                {{"ICN", "B"}, {"B", "ICN"}, {"ICN", "A"}, {"A", "D"}, {"D", "A"}},
                {{"ICN", "A"}, {"ICN", "B"}, {"B", "ICN"}},
                {{"ICN", "AAA"}, {"ICN", "AAA"}, {"ICN", "AAA"}, {"AAA", "ICN"}, {"AAA", "ICN"}}
        };


        System.out.println(Arrays.toString(t.solution(exam[0])));

    }

    public String[] solution(String[][] tickets) {
        List<Pair> pairTickets = new LinkedList<>();
        for(String[] ticket : tickets) {
            pairTickets.add(new Pair(ticket[0], ticket[1]));
        }
        pairTickets.sort((pair, t1) -> {
            if(pair.first.compareTo(t1.first) == 0) {
                return pair.second.compareTo(t1.second);
            }
            return pair.first.compareTo(t1.first);
        });

        String [] answer = new String[tickets.length + 1];
        answer[0] = "ICN";
        return dfs(0, pairTickets, answer);
    }

    public String[] dfs(int index, List<Pair> target, String[] ans) {
        if(target.size() == 0) {
            return ans;
        }

        String[] compareA = {};
        String [] compareB;

        for(Pair t : target) {
            if(t.first.equals(ans[index])) {
                List<Pair> newTarget = new LinkedList<>(List.copyOf(target));
                newTarget.remove(t);
                String[] newAnswer= ans.clone();
                newAnswer[index + 1] = t.second;

                compareB = dfs(index+1, newTarget, newAnswer);

                if(compareB.length == 0) continue;
                if(compareA.length == 0) {
                    compareA = compareB;
                } else {
                    for(int i = 0; i < compareA.length; i++) {
                        if(compareA[i].compareTo(compareB[i]) < 0) {
                            return compareA;
                        } else if(compareA[i].compareTo(compareB[i]) > 0) {
                            return compareB;
                        }
                    }
                }
            }
        }
        return compareA;
    }

    static class Pair {
        String first;
        String second;

        Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }
    }
}
