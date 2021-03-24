// 3 Score
package brute_force;

import java.util.ArrayList;
import java.util.HashSet;

public class Search_Prime_Number {
    public static void main(String[] args) {
       Search_Prime_Number SPN = new Search_Prime_Number();
    }
    private Search_Prime_Number() {
        System.out.println(solution("17"));
        System.out.println(solution("011"));
    }

    HashSet<Integer> isChecked;
    HashSet<Integer> primeNum;

    public int solution(String numbers) {
        int length = numbers.length();
        ArrayList<Integer> array = new ArrayList<>();
        isChecked = new HashSet<>();
        primeNum = new HashSet<>();
        int num;
        for(char a : numbers.toCharArray()) array.add(Character.getNumericValue(a));
        for(int i = 0; i<length; i++) {
            num = array.remove(i);
            recursive(num, array);
            array.add(i, num);
        }
        return primeNum.size();
    }

    public void recursive(int num ,ArrayList<Integer> arrayList) {
        if(isChecked.add(num) && checkPrime(num)) {
            primeNum.add(num);
        }
        for(int i = 0 ; i< arrayList.size(); i++) {
            num = num * 10 + arrayList.remove(i);
            recursive(num, arrayList);
            arrayList.add(i, num % 10);
            num = num / 10;
        }
    }

    public boolean checkPrime(int number) {
        if(number == 1 || number == 0) return false;
        for(int i = 2  ; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
}
