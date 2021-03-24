// 5 Score
package Kakao_2018;

import java.util.Arrays;
import java.util.HashMap;

public class Sort_FileName {
    public static void main(String[] args) {
        Sort_FileName SF = new Sort_FileName();
    }

    private Sort_FileName() {
        System.out.println(Arrays.toString(solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F 14 Tomcat"})));
        System.out.println(Arrays.toString(solution(new String[]{"foo0000000000000000000009.txt", "foo010bar020.zip", "F-15"})));
        System.out.println(Arrays.toString(solution(new String[]{"muzi1.txt", "MUZI1.txt", "muzi001.txt", "muzi1.TXT"})));
        System.out.println(Arrays.toString(solution(new String[]{"C-5", "C-12", "A-1", "A-2", "A-3", "B-4", "B-12", "b-8"})));
    }

    public String[] solution(String[] file) {
        HashMap<Integer, String> head = new HashMap<>();
        HashMap<Integer, Integer> num = new HashMap<>();
        int length = file.length;
        String tmp = "";
        if(length == 0 || length == 1)
            return file;
        for(int i = 0 ; i<length; i++) {
            int j = 0;
            while(!Character.isDigit(file[i].charAt(j))) {
                tmp += file[i].charAt(j);
                j++;
            }
            head.put(i, tmp);
            tmp = "";
            while(Character.isDigit(file[i].charAt(j))) {
                tmp += file[i].charAt(j);
                j++;
                if(j == file[i].length())
                    break;
            }
            num.put(i, Integer.parseInt(tmp));
            tmp = "";
        }
        for(int i = 1; i<length; i++) {
            for(int j = 0; j<length-i; j++) {
                if(head.get(j).compareToIgnoreCase(head.get(j+1)) > 0) {
                    swap(head, num, j, file);
                }
                else if(head.get(j).compareToIgnoreCase(head.get(j+1)) == 0){
                    if(num.get(j) > num.get(j+1)) {
                        swap(head, num, j, file);
                    }
                }
            }
        }
        return file;
    }
    public void swap(HashMap<Integer, String> head, HashMap<Integer, Integer> num, int j, String[] file) {
        String headtmp = head.get(j);
        int numtmp = num.get(j);
        head.replace(j, head.get(j+1));
        head.replace(j+1, headtmp);
        num.replace(j, num.get(j+1));
        num.replace(j+1, numtmp);
        headtmp = file[j];
        file[j] = file[j+1];
        file[j+1] = headtmp;
    }
}