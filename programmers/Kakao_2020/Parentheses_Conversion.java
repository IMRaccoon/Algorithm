package Kakao_2020;

public class Parentheses_Conversion {
    private Parentheses_Conversion() {
        System.out.println(solution("(()())()"));
        System.out.println(solution(")("));
        System.out.println(solution("()))((()"));
    }

    public static void main(String[] args) {
        Parentheses_Conversion pc = new Parentheses_Conversion();
    }

    public String solution(String p) {
        StringBuilder new_p = new StringBuilder(p);
        return recursive(new_p).toString();
    }

    public StringBuilder recursive(StringBuilder p) {
        int count = 0;
        int length = p.length();
        int min_perfect = 0;

        if (length == 0) {
            return p;
        }
        System.out.println("p : " + p);
        for (int i = 0; i < length; i++) {
            if (p.charAt(i) == '(') {
                count += 1;
            } else {
                count -= 1;
                min_perfect = Math.min(count, min_perfect);
            }
            if (count == 0) {
                StringBuilder v = new StringBuilder(p.substring(i + 1));
                if (min_perfect == 0) {
                    StringBuilder u = new StringBuilder(p.substring(0, i + 1));
                    return u.append(recursive(v));
                } else {
                    StringBuilder u = new StringBuilder(p.substring(1, i));
                    for (int j = 0; j < u.length(); j++) {
                        if (u.charAt(j) == '(') {
                            u.setCharAt(j, ')');
                        } else if (u.charAt(j) == ')') {
                            u.setCharAt(j, '(');
                        }
                    }
                    return new StringBuilder().append("(").append(recursive(v)).append(")").append(u);
                }
            }
        }
        return null;
    }
}