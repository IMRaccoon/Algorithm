// 1 Score
package dfs_bfs;

public class Network {
    public static void main(String[] args) {
        Network N = new Network();
    }

    private Network() {
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}));
        System.out.println(solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}}));
    }
    class NetworkData {
        int [] linkedData;
        int networkIndex;
        int self;
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        NetworkData[] data= new NetworkData[n];
        for(int i = 0 ; i<n; i++) {
            data[i] = new NetworkData();
            data[i].linkedData = computers[i];
            data[i].networkIndex = 0;
            data[i].self = i;
        }
        for(int i = 0; i<n; i++) {
            if(data[i].networkIndex == 0) data[i].networkIndex = ++answer;
            dfs(data,i,answer, n);
        }
        return answer;
    }
    private void dfs(NetworkData[] data, int i, int networkIndex, int n) {
        for(int j = 0; j<n; j++) {
            if(data[i].linkedData[j] == 1 && i != j && data[j].networkIndex != networkIndex) {
                data[j].networkIndex = networkIndex;
                dfs(data, j, networkIndex, n);
            }
        }
    }
}
