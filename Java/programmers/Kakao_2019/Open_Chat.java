// 4 Score
package Kakao_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Open_Chat {
    public static void main(String[] args) {
        Open_Chat OC = new Open_Chat();
    }
    private Open_Chat() {
        System.out.println(Arrays.toString(solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"})));
    }
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> user = new HashMap<>();
        for(String command : record) {
            command += " ";
            switch (command.split(" ")[0]) {
                case "Enter" :
                    if(!user.containsKey(command.split(" ")[1]))
                        user.put(command.split(" ")[1], command.split(" ")[2]);
                    else
                        user.replace(command.split(" ")[1], command.split(" ")[2]);
                    break;
                case "Change" :
                    if(user.containsKey(command.split(" ")[1]))
                        user.replace(command.split(" ")[1], command.split(" ")[2]);
                    break;
                default:
                    break;
            }
        }
        for(String command : record) {
            command += " ";
            switch (command.split(" ")[0]) {
                case "Enter" :
                    answer.add(user.get(command.split(" ")[1])+"님이 들어왔습니다.");
                    break;
                case "Leave" :
                    answer.add(user.get(command.split(" ")[1])+"님이 나갔습니다.");
                default:
                    break;
            }
        }
        return answer.stream().toArray(String[]::new);
    }
}
