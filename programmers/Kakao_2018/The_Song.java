// 7 Score
package Kakao_2018;

import java.text.SimpleDateFormat;
import java.util.Date;

public class The_Song {
    public static void main(String[] args) {
        The_Song TS = new The_Song();
    }

    private The_Song() {
        //System.out.println(solution("ABCDEF", new String[]{"12:00,12:16,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B", new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC", new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }

    public String solution(String m, String[] musicinfos) {
        int length = musicinfos.length;
        int[] time = new int[length];
        String [] song = new String[length];
        String [] name = new String[length];
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        Date d1, d2;
        StringBuilder tmp;
        for (int i = 0; i < length; i++) {
            try {
                d1 = format.parse(musicinfos[i]);
                d2 = format.parse(musicinfos[i].split(",")[1]);
                time[i] = (int)(d2.getTime() - d1.getTime() + 1) / 60000;
                name[i] = musicinfos[i].split(",")[2].split(",")[0];
                song[i] = musicinfos[i].split(",")[3];
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(int i = 0 ; i < length; i++) {
            tmp = new StringBuilder();
            int a;
            for(int j =0 ; j< song[i].length() ; j++) {
                if(song[i].charAt(j) == '#')
                    tmp.setCharAt(tmp.length()-1, Character.toLowerCase(tmp.charAt(tmp.length()-1)));
                else {
                    tmp.append(song[i].charAt(j));
                }
            }
            a = tmp.length();
            for(int j = 0; j< time[i]; j++) {
                tmp.append(tmp.charAt(j % a));
            }
            tmp.delete(0, a-1);
            song[i] = tmp.toString();
        }
        tmp = new StringBuilder();
        for(int i = 0 ; i < m.length(); i++) {
            if(m.charAt(i) == '#')
                tmp.setCharAt(tmp.length()-1, Character.toLowerCase(tmp.charAt(tmp.length()-1)));
            else
                tmp.append(m.charAt(i));
        }
        m = tmp.toString();
        int songNum = 0;
        int songLength = 0;
        for(int i = 0 ; i<musicinfos.length; i++) {
            if(song[i].contains(m)) {
                songNum = time[i] > songLength ? i : songNum;
                songLength = time[i] > songLength ? time[i] : songLength;
            }
        }
        if(songLength == 0)
            return "(None)";
        else
            return name[songNum];
    }
}
