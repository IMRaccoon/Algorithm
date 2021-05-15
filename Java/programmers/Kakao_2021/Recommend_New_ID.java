package Kakao_2021;

public class Recommend_New_ID {
    public static void main(String[] args) {
        Recommend_New_ID r = new Recommend_New_ID();
        r.solution("...!@BaT#*..y.abcdefghijklm");
        r.solution("z-+.^.");
        r.solution("=.=");
        r.solution("123_.def");

    }

    public String solution(String new_id) {
        // case 1
        new_id = new_id.toLowerCase();
        // case 2
        new_id = new_id.replaceAll("[^\\w\\d.\\-]", "");
        // case 3
        new_id = new_id.replaceAll("\\.{2,}", ".");
        // case 4
        new_id = new_id.charAt(0) == '.' ? new_id.substring(1) : new_id;
        new_id = new_id.length() > 0 && new_id.charAt(new_id.length() - 1) == '.' ? new_id.substring(0, new_id.length() - 1) : new_id;
        // case 5
        new_id = new_id.isEmpty() ? "a" : new_id;
        // case 6
        new_id = new_id.length() > 15 ? new_id.substring(0, 15) : new_id;
        new_id = new_id.charAt(new_id.length() - 1) == '.' ? new_id.substring(0, new_id.length() - 1) : new_id;
        // case 7
        int size = new_id.length();
        if(size < 3) {
            StringBuilder new_idBuilder = new StringBuilder(new_id);
            for(int i = 0; i < 3; i++) {
                new_idBuilder.append(new_idBuilder.charAt(new_idBuilder.length() - 1));
            }
            new_id = new_idBuilder.toString();
            new_id = new_id.substring(0, 3);
        }
        return new_id;
    }
}
