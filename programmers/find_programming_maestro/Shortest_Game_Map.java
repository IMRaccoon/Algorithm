package find_programming_maestro;

public class Shortest_Game_Map {
    public static void main(String[] args) {
        Shortest_Game_Map SGM = new Shortest_Game_Map();
    }
    private Shortest_Game_Map() {
        System.out.println(solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,1}, {0,0,0,0,1}}));
        System.out.println(solution(new int[][] {{1,0,1,1,1}, {1,0,1,0,1}, {1,0,1,1,1}, {1,1,1,0,0}, {0,0,0,0,1}}));
    }
    public int solution(int [][] maps) {
        int answer = 1;
        return answer;
    }
}
