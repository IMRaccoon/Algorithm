// 9 Score
package greedy;

public class Rescue_Boat {
    public static void main(String[] args) {
        Rescue_Boat Rb = new Rescue_Boat();
    }
    public Rescue_Boat() {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }
    public int solution(int [] people, int limit) {
        int answer = 0, num = 0, size = people.length;
        Quick quick = new Quick();
        quick.sort(people, 0, size-1);
        do { answer++;
            if(limit-people[num] >= people[size-1]) {
                num++; size--; }
            else num++;
        } while(size > num);
        return answer;
    }
    public class Quick {
        public void sort(int[] data, int l, int r){
            int left = l;
            int right = r;
            int pivot = data[(l+r)/2];

            do{
                while(data[left] > pivot) left++;
                while(data[right] < pivot) right--;
                if(left <= right){
                    int temp = data[left];
                    data[left] = data[right];
                    data[right] = temp;
                    left++;
                    right--;
                }
            }while (left <= right);
            if(l < right) sort(data, l, right);
            if(r > left) sort(data, left, r);
        }
    }
}