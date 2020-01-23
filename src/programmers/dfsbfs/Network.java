/*네트워크
문제 설명
네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고,
컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다.
따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.

컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.

제한사항
컴퓨터의 개수 n은 1 이상 200 이하인 자연수입니다.
각 컴퓨터는 0부터 n-1인 정수로 표현합니다.
i번 컴퓨터와 j번 컴퓨터가 연결되어 있으면 computers[i][j]를 1로 표현합니다.
computer[i][i]는 항상 1입니다.
입출력 예
n	computers	return
3	[[1, 1, 0], [1, 1, 0], [0, 0, 1]]	2
3	[[1, 1, 0], [1, 1, 1], [0, 1, 1]]	1*/

package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

//재귀를 통한 bfs 탐색
public class Network {

    private static boolean []visited;

    public static void main(String[] args) {
        Network n = new Network();
        int [][] arr = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; //간선의 이어짐을 나타냄
        int target = 3; //정점 3개
        System.out.println(n.solution(target, arr));
    }
    public int solution(int target, int[][] computers) {
        int answer = 0;
        //boolean의 default는 false
        visited = new boolean[target];

        for(int idx=0; idx<target; idx++){
            if(!visited[idx]){
                bfs(target, idx, computers);
                answer++;
            }
        }

        return answer;
    }

    private void bfs(int target, int idx, int[][] computers) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(idx); //0
        visited[idx] = true; //0을 true

        while(!que.isEmpty()){
            int temp = que.poll(); // 0을 뺌
            visited[temp] = true; //0을 true
            //{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}
            for(int i=0; i<target; i++){
                if(computers[temp][i] == 1 && !visited[i]){
                    que.offer(i);
                }
            }
        }
    }


}