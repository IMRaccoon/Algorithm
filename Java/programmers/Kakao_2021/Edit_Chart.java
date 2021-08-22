package Kakao_2021;

import java.util.Stack;

public class Edit_Chart {
    public static void main(String[] args) {
        Edit_Chart ec = new Edit_Chart();
        System.out.println(ec.solution(8, 2, new String[]{"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z", "U 1", "C"}));
    }

    public String solution(int N, int K, String[] cmd) {
        Stack<Integer> deleted = new Stack<>();
        int pos = K;
        int size = N;

        char cur;
        for(String c : cmd) {
            cur = c.charAt(0);
            if (cur == 'U') {
                pos -= Integer.parseInt(c.substring(2));
            } else if (cur == 'D') {
                pos += Integer.parseInt(c.substring(2));
            } else if (cur == 'C') {
                deleted.push(pos);
                size -= 1;
                if (pos == size) pos -= 1;
            } else if (cur == 'Z') {
                int restore = deleted.pop();
                if (restore <= pos) pos += 1;
                size += 1;
            }
        }
        StringBuilder answer = new StringBuilder("O".repeat(size));
        while(!deleted.isEmpty()) {
            answer.insert(deleted.pop(), "X");
        }
        return answer.toString();
    }
}
