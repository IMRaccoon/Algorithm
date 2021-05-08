// 6 Score
package Kakao_2018;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chuseok_Traffic {
    public static void main(String[] args) {
        Chuseok_Traffic CT = new Chuseok_Traffic();
    }
    private Chuseok_Traffic() {
        //System.out.println(solution(new String[]{"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"}));
        //System.out.println(solution(new String[]{"2016-09-15 01:00:02.003 2.0s", "2016-09-15 01:00:05.001 2s"}));
        System.out.println(solution(new String[]{"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"}));
    }
    public int solution(String[] lines) {                   // 시간 순서대로 들어온다는 조건, delay 에서 1초 시작하는 범위만 확인해준다.
        Date date;
        long [] time = new long[lines.length];
        float [] delay = new float[lines.length];
        int answer = 0, flag;
        try {
            for (int i = 0; i < lines.length; i++) {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(lines[i]);
                time[i] = date.getTime();
                delay[i] = Float.parseFloat(lines[i].split(" ")[2].split("s")[0]);
            }
        } catch (ParseException e){
            e.printStackTrace();
        }
        for(int i = 0; i<lines.length; i++) {
            flag = 0;
            for(int j = 0; j<lines.length; j++) {
                if(time[i] <= time[j] && (time[i]+ 999 > time[j] - (long)(delay[j]*1000))) {
                   flag += 1;
                }
            }
            answer = answer > flag ? answer : flag;
        }
        return answer;
    }
}
