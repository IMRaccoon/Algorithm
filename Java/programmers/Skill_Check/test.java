package Skill_Check;

import java.util.Collections;
import java.util.LinkedList;

public class test {
    public static void main(String[] args) {
        test test = new test();
    }

    private test() {
        System.out.println(solution(10, new int[]{2, 3, 7, 8}));
        System.out.println(solution(5, new int[]{2, 2, 2, 2, 2}));
        System.out.println(solution(20, new int[]{16, 15, 9, 17, 1, 3}));
    }

    LinkedList<Integer> linkedList;
    public int solution(int M, int[] load) {
        int answer = 0;
        linkedList = new LinkedList<>();
        for(int a : load) linkedList.add(a);
        Collections.sort(linkedList, Collections.reverseOrder());
        if(linkedList.getFirst() > M) return -1;

        LinkedList<Integer> remove = new LinkedList<>();
        LinkedList<Integer> removeTmp = new LinkedList<>();
        int targetM;
        int tmpM;
        int biggest;
        while(!linkedList.isEmpty()) {
            biggest = 0;
            targetM = M - linkedList.removeFirst();
            tmpM = 0;
            remove.clear();
            removeTmp.clear();

            for(int i = 0; i < linkedList.size(); i++) {
                if(targetM >= linkedList.get(i)) {
                    tmpM = recursive(tmpM, i, targetM, removeTmp);
                    if(tmpM > biggest) {
                        remove = (LinkedList<Integer>)removeTmp.clone();
                        biggest = tmpM;
                    }
                    tmpM = 0;
                    removeTmp.clear();
                }
            }
            for(int j = remove.size()-1; j>=0; j--) {
                linkedList.remove((int)remove.get(j));
            }
            answer += 1;
        }
        return answer;
    }
    public int recursive(int tmpM, int index, int targetM, LinkedList<Integer> remove) {
        if(index == linkedList.size()) {
            return tmpM;
        }
        else if(tmpM + linkedList.get(index) == targetM) {
            remove.add(index);
            return tmpM + linkedList.get(index);
        }
        else if(tmpM + linkedList.get(index) > targetM) {
            return recursive(tmpM, index+1, targetM, remove);
        }
        else {
            remove.add(index);
            return recursive(tmpM+linkedList.get(index), index+1, targetM, remove);
        }
    }

}
