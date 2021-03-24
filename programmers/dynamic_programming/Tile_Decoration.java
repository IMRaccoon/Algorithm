package dynamic_programming;

public class Tile_Decoration {
    public static void main(String[] args) {
        Tile_Decoration TD = new Tile_Decoration();
    }
    public Tile_Decoration() {
        System.out.println(solution(3));
        System.out.println(solution(5));
    }
    public long solution(int N) {
        long swap = 0;
        long a = 1;
        long b = 1;
        while(--N != 0) {
            swap = a;
            a = a+b;
            b = swap;
        }
        return (a + b) * 2;
    }
}
