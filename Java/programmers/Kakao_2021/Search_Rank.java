package Kakao_2021;

import java.util.*;

public class Search_Rank {
    public static void main(String[] args) {
        Search_Rank s = new Search_Rank();
        System.out.println(Arrays.toString(s.solution(
                new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"},
                new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
    }


    String[][] conditions = new String[][]{{"cpp", "java", "python"}, {"backend", "frontend"}, {"junior", "senior"}, {"chicken", "pizza"}};

    public Integer[] solution(String[] infos, String[] queries) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (String info : infos) {
            String[] input = info.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) sb.append(input[i]);
            map.putIfAbsent(sb.toString(), new ArrayList<>());
            map.get(sb.toString()).add(Integer.parseInt(input[4]));
        }

        for(List<Integer> list : map.values()) {
            list.sort(Comparator.naturalOrder());
        }

        List<Integer> answer = new ArrayList<>();
        for (String query : queries) {
            String[] input = query.replaceAll("and ", "").split(" ");
            int score = Integer.parseInt(input[4]);
            Set<String> people = new HashSet<>();
            dfs("", input, 0, people);
            int cnt = 0;
            for (String p : people) {
                List<Integer> scores = map.get(p);
                if (scores == null || scores.isEmpty()) continue;
                int l = 0, r = scores.size() - 1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if (scores.get(m) < score) {
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                cnt += (scores.size() - l);
            }
            answer.add(cnt);
        }

        return answer.toArray(new Integer[0]);
    }

    private void dfs(String acc, String[] input, int depth, Set<String> people) {
        if (depth == 4) {
            people.add(acc);
            return;
        }
        if (input[depth].equals("-")) {
            for (String condition : conditions[depth]) {
                dfs(acc + condition, input, depth + 1, people);
            }
        } else {
            dfs(acc + input[depth], input, depth + 1, people);
        }
    }
}