package Kakao_2019;

public class MeogBang_Live {
    public static void main(String[] args) {
        MeogBang_Live meogBang_live = new MeogBang_Live();
    }
    private MeogBang_Live() {
        System.out.println(solution(new int[]{3, 1, 2}, 5));
    }
    public int solution(int[] food_times, long k) {
        int length = food_times.length;
        long divid = Math.floorDiv(k, length);
        long rest = Math.floorMod(k, length);
        do{
            for(int i = 0 ; i<length; i++) {
                if(food_times[i] == 0);
                else if(food_times[i] >= divid)
                    food_times[i] -= divid;
                else {
                    rest += divid - food_times[i];
                    food_times[i] = 0;
                }
            }
            divid = Math.floorDiv(k, length);
        }while(divid == 0);
        int rotate = 0;
        while(rest != 0) {
            if(food_times[rotate] == 0);
            else {
                food_times[rotate] -= 1;
                rest -= 1;
            }
            rotate++;
            if(rotate == length) rotate = 0;
        }
        return rotate+1;
    }
}
