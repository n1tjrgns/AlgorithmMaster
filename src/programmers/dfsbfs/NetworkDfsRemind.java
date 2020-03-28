package programmers.dfsbfs;

public class NetworkDfsRemind {
    public int solution(int n, int[][] computers) { //컴퓨터 개수, 네트워크 연결 정보
        int answer = 0;
        //방문 여부 표시
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            System.out.println(visited[i]);
            if(!visited[i]){
                dfs(n, i, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int n, int i, int[][] computers, boolean[] visited) {
        visited[i] = true; //방문 표시

        for(int idx=0; idx<n; idx++){
            if(computers[i][idx] == 1 && !visited[idx]){ //연결 되어있지만 방문 안 한 경우 = 탐색 대상
                dfs(n, idx, computers, visited);
            }
        }
    }


    public static void main(String[] args) {
        /*3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
          3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1*/
        NetworkDfsRemind n = new NetworkDfsRemind();
        System.out.println(n.solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    }
}
