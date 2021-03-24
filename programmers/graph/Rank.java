package graph;

import java.util.ArrayList;

public class Rank {
    public static void main(String[] args) {
        Rank rank = new Rank();
    }
    private Rank() {
        System.out.println(solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
    public int solution(int n, int [][] results) {
        int answer = 0;
        int length = results.length;
        Graph [] graphs = new Graph[n];
        for(int i = 0 ; i<n; i++) graphs[i] = new Graph();
        for(int i = 0; i<length; i++) {
            graphs[results[i][0]-1].addWinGame(graphs[results[i][1]-1]);
            graphs[results[i][1]-1].addLoseGame(graphs[results[i][0]-1]);
        }
        for(Graph graph : graphs) if(graph.players == n-1) answer += 1;
        return answer;
    }
    private class Graph {
        int [] plays;
        int players;
        private ArrayList<Graph> winners;
        private ArrayList<Graph> losers;

        public Graph() {
            plays = new int[] {0, 0};       // plays[0] = win count, plays[1] = lose count
            players = 0;
            winners = new ArrayList<>();
            losers = new ArrayList<>();
        }

        public void addWinGame(Graph loser) {
            if(!losers.contains(loser)) {
                losers.add(loser);
                this.plays[0]++;

            }
            // winner들에게 자기 자신을 다 추가해줘야되나...?
        }

        public void addLoseGame(Graph winner) {
            if(!winners.contains(winner)) {
                winners.add(winner);
                this.plays[1]++;
            }
            // 자식 Loser들 다 추가해줘야됨
        }
    }
}
