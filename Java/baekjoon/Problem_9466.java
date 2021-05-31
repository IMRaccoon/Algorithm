import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Problem_9466 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int test = Integer.parseInt(br.readLine());

        for(int t = 0 ; t < test; t ++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int [] arr = new int[n];
            // 0 not visited, 1 visited but not cycle, 2 cycle
            int [] isTeam = new int[n];
            int answer = 0;
            HashSet<Integer> array;

            for(int i = 0 ; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken()) - 1;
                if(arr[i] == i) {
                    isTeam[i] = 2;
                    answer += 1;
                }
            }


            for(int i = 0 ; i < n; i++) {
                if(isTeam[i] != 0) continue;
                array = new HashSet<>();
                int next = arr[i];
                array.add(i);

                while(!array.contains(next) && i != next && isTeam[next] == 0) {
                    array.add(next);
                    next = arr[next];
                }

                if(i == next) {
                    for(int index : array) {
                        isTeam[index] = 2;
                        answer += 1;
                    }
                } else if(isTeam[next] != 0) {
                    for(int index : array) {
                        isTeam[index] = 1;
                    }
                }
            }
            bw.write(String.valueOf(n - answer));
            bw.newLine();
        }
        bw.flush();
    }
}
