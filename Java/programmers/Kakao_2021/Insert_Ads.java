package Kakao_2021;

public class Insert_Ads {
    public static void main(String[] args) {
        Insert_Ads ia = new Insert_Ads();
        String answer = ia.solution("99:59:59", "25:00:00", new String[]{"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"});
        System.out.println(answer);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        int endTime = transferTimeToSec(play_time);
        int adTime = transferTimeToSec(adv_time);
        int length = logs.length;


        int [] history = new int[endTime + 1];

        for (int i = 0; i < length; i++) {
            String[] durations = logs[i].split("-");
            int start = transferTimeToSec(durations[0]);
            int end = transferTimeToSec(durations[1]);
            history[start] += 1;
            history[end] -= 1;
        }

        for(int i = 1; i <= endTime; i++) history[i] += history[i - 1];

        long acc = 0;
        int maxTime = 0;
        for(int i = 0; i < adTime; i++) acc += history[i];

        long cur = acc;
        for(int start = 0; start <= endTime - adTime; start ++) {
            cur = cur - history[start] + history[start + adTime];
            if (cur > acc) {
                maxTime = start + 1;
                acc = cur;
            }
        }
        return transferSecToTime(maxTime);
    }

    private int transferTimeToSec(String input) {
        String[] parts = input.split(":");
        int h = Integer.parseInt(parts[0]) * 3600;
        int m = Integer.parseInt(parts[1]) * 60;
        int s = Integer.parseInt(parts[2]);
        return h + m + s;
    }

    private String transferSecToTime(int input) {
        String h = String.valueOf(input / 3600);
        input %= 3600;
        String m = String.valueOf(input / 60);
        input %= 60;
        String s = String.valueOf(input);
        return (h.length() == 1 ? "0" + h : h) + ":" + (m.length() == 1 ? "0" + m : m) + ":" + (s.length() == 1 ? "0" + s : s);
    }
}
