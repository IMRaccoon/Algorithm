// 3 Score
package graph;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class The_Longest_Node {
    public static void main(String[] args) {
        The_Longest_Node TLN = new The_Longest_Node();
    }

    private The_Longest_Node() {
        System.out.println(solution(6, new int[][]{{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}}));
    }

    private class Graph{
        List<Graph> child;
        boolean hasBeen = false;
        Graph() { child = new LinkedList<>(); }
        void addChild(Graph tmp) { this.child.add(tmp); }
        int size() {return this.child.size(); }

        int longestNodeNum() {
            Queue<Graph> queue = new ArrayDeque<>();
            int childSize = this.size();
            this.hasBeen = true;
            for(int i = 0 ; i<childSize; i++) {
                queue.offer(this.child.get(i));
                this.child.get(i).hasBeen = true;
            }
            while(!queue.isEmpty()) {
                childSize = queue.size();
                Graph polled;
                for(int i = 0 ; i<childSize; i++) {
                    polled = queue.poll();
                    for (int j = 0; j < polled.size(); j++) {
                        if(!polled.child.get(j).hasBeen) {
                            queue.offer(polled.child.get(j));
                            polled.child.get(j).hasBeen = true;
                        }
                    }
                }
            }
            return childSize;
        }
    }

    public int solution(int n, int[][] edge) {
        // initialization graph data structure
        Graph [] graphs = new Graph[n];
        for(int i = 0 ; i<n; i++) graphs[i] = new Graph();
        for(int i = 0 ; i<edge.length; i++) {
            graphs[edge[i][0]-1].addChild(graphs[edge[i][1]-1]);
            graphs[edge[i][1]-1].addChild(graphs[edge[i][0]-1]);
        }
        return graphs[0].longestNodeNum();
    }
}
