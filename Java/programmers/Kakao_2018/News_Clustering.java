// 3 Score
package Kakao_2018;

import java.util.LinkedList;

public class News_Clustering {
    public static void main(String[] args) {
        News_Clustering NC = new News_Clustering();
    }
    public News_Clustering() {
        System.out.println(solution("FRANCE", "french"));
        System.out.println(solution("handshake", "shake hands"));
        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
    public int solution(String str1, String str2) {
        int a = 0, b = 0;
        LinkedList<String> list1 = new LinkedList<>();
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        for(int i = 0 ; i<str1.length()-1; i++) {
            if(Character.isAlphabetic(str1.charAt(i)) && Character.isAlphabetic(str1.charAt(i+1))) {
                list1.add(str1.substring(i, i + 2));
                b+=1;
            }
        }
        for(int i = 0 ; i<str2.length()-1; i++) {
            if(Character.isAlphabetic(str2.charAt(i))&& Character.isAlphabetic(str2.charAt(i+1))) {
                if (list1.contains(str2.substring(i, i + 2))) {
                    list1.remove(str2.substring(i, i + 2));
                    a += 1;
                    b -= 1;
                }
                b += 1;
            }
        }
        if(b == 0)
            return 65536;
        else
            return (a* 65536)/b;
    }
}
