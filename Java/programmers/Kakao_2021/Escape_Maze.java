package Kakao_2021;

import java.util.*;

public class Escape_Maze {
    public static void main(String[] args) {
        Escape_Maze em = new Escape_Maze();
        System.out.println(em.solution(3, 1, 3, new int[][]{{1, 2, 2}, {3, 2, 3}}, new int[]{2}));
        System.out.println(em.solution(4, 1, 4, new int[][]{{1, 2, 1}, {3, 2, 1}, {2, 4, 1}}, new int[]{2, 3}));
    }

    public int solution(int n, int start, int end, int[][] roads, int[] traps) {
        int roadSize = roads.length;
        if (start == end) return 0;
        ArrayList<Integer>[][] links = new ArrayList[n + 1][2];
        HashSet<String>[] visited = new HashSet[n + 1];
        for (int i = 1; i <= n; i++) visited[i] = new HashSet<>();

        for (int i = 0; i < roadSize; i++) {
            if (links[roads[i][0]][0] == null) links[roads[i][0]][0] = new ArrayList<>();
            if (links[roads[i][1]][1] == null) links[roads[i][1]][1] = new ArrayList<>();
            links[roads[i][0]][0].add(i);
            links[roads[i][1]][1].add(i);
        }

        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(node -> node.time));
        q.offer(new Node(start, 0, "0".repeat(roadSize).toCharArray()));

        int answer = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.pos].contains(String.valueOf(cur.status))) continue;
            visited[cur.pos].add(String.valueOf(cur.status));

            for (int t : traps) {
                if (t != cur.pos) continue;
                if (links[cur.pos][0] != null) {
                    for (int next : links[cur.pos][0]) cur.status[next] = cur.status[next] == '0' ? '1' : '0';
                }
                if (links[cur.pos][1] != null) {
                    for (int next : links[cur.pos][1]) cur.status[next] = cur.status[next] == '0' ? '1' : '0';
                }
                break;
            }

            if (links[cur.pos][0] != null) {
                for (int next : links[cur.pos][0]) {
                    if (cur.status[next] == '1') continue;
                    int nextTime = cur.time + roads[next][2];
                    if (answer <= nextTime) continue;
                    if (roads[next][1] == end) answer = Math.min(answer, nextTime);
                    else q.offer(new Node(roads[next][1], cur.time + roads[next][2], cur.status.clone()));
                }
            }
            if (links[cur.pos][1] != null) {
                for (int next : links[cur.pos][1]) {
                    if (cur.status[next] == '0') continue;
                    int nextTime = cur.time + roads[next][2];
                    if (answer <= nextTime) continue;
                    if (roads[next][0] == end) answer = Math.min(answer, nextTime);
                    else q.offer(new Node(roads[next][0], cur.time + roads[next][2], cur.status.clone()));
                }
            }

        }
        return answer;
    }

    private class Node {
        int pos, time;
        char[] status;

        Node(int pos, int time, char[] status) {
            this.pos = pos;
            this.time = time;
            this.status = status;
        }
    }
}
