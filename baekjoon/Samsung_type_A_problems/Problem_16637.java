package Samsung_type_A_problems;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/** 규칙 1. 사칙연산의 규칙을 따르지 않고 왼쪽부터 순서대로 계산된다.
 *  규칙 2. 정수는 0~9까지 들어온다.
 *  규칙 3. 괄호안에 부호는 1개만 들어갈 수 있다. ex. (1+2)+3 == true, (1+2+3) == false
 */
public class Problem_16637 {
    static LinkedList<Boolean[]> array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> number = new LinkedList<>();
        LinkedList<Character> operator = new LinkedList<>();
        array = new LinkedList<>();
        int arrayLength = Integer.parseInt(br.readLine());
        char[] a = br.readLine().toCharArray();
        for(int i = 0 ; i < arrayLength; i++) {
            if (i % 2 == 0) number.add(Integer.parseInt(String.valueOf(a[i])));
            else operator.add(a[i]);
        }

        int length = operator.size();
        Boolean[] bool = new Boolean[length];
        Arrays.fill(bool, Boolean.FALSE);
        recursive(bool, 0, length);

        int answer = calculation(array.get(0), (LinkedList<Integer>) number.clone(), (LinkedList<Character>) operator.clone());;
        for(int i = 1; i< array.size(); i++) {
            int tmp = calculation(array.get(i), (LinkedList<Integer>) number.clone(), (LinkedList<Character>) operator.clone());
            answer = tmp > answer ? tmp : answer;
        }
        System.out.println(answer);
    }


    public static void recursive(Boolean[] booleans, int start, int end) {
        if(start == end) {
            array.add(booleans.clone());
            return;
        }
        if(start == 0) {
            booleans[start] = true;
            recursive(booleans, start + 1, end);
            booleans[start] = false;
            recursive(booleans, start + 1, end);
        }
        else if(booleans[start-1]) {
            recursive(booleans, start + 1, end);
        }
        else {           // 1
            booleans[start] = true;
            recursive(booleans, start + 1, end);
            booleans[start] = false;
            recursive(booleans, start + 1, end);
        }
    }
    public static int calculation(Boolean[] booleans, LinkedList<Integer> nums, LinkedList<Character> opers) {
        for(int i = 0 ; i <booleans.length; i++) {
            if(booleans[i]) {
                nums.set(i, calculator(nums.get(i), opers.get(i), nums.get(i + 1)));
                opers.set(i, '/');
                nums.set(i + 1, -1);
            }
        }
        for(int i = 0 ; i < opers.size(); i++) {
            nums.set(i+1, calculator(nums.get(i), opers.get(i), nums.get(i+1)));
        }
        return nums.peekLast();
    }

    public static int calculator(int a, char exp, int b) {
        if(b == -1) {
            return a;
        }
        switch (exp) {
            case '+' : return a+b;
            case '-' : return a-b;
            case '*' : return a*b;
            default: return a;
        }
    }
}
