package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

class FurthestNode {

    private static LinkedList<Integer>[] adList;
    private static int[] distance;

    public void connect(int x, int y){
        adList[x].add(y);
        adList[y].add(x);
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        adList = new LinkedList[n+1];
        distance = new int[n+1];

        for(int i=0; i<n+1; i++){
            adList[i] = new LinkedList<>();
        }

        for(int i=0; i<edge.length; i++){
            connect(edge[i][0],edge[i][1]);
        }
        boolean[] visited = new boolean[n+1];

        bfs(adList, visited, distance);

        int max = 0;
        for(int i=0; i<distance.length; i++){
            if(distance[i]>max){
                max = distance[i];
            }
        }

        for(int dist : distance){
            if(dist == max){
                answer++;
            }
        }

        return answer;
    }

    private void bfs(LinkedList<Integer>[] adList, boolean[] visited, int[] distance) {
        Queue<Integer> que = new LinkedList<>();
        que.add(1); //시작점 1
        visited[1] = true;

        while(!que.isEmpty()){
            int current = que.poll();

            System.out.println("current : " + current);
            for(int i=0; i<adList[current].size(); i++){
                int now = adList[current].get(i);

                if(!visited[now]){
                    que.add(now);
                    visited[now] = true;
                    distance[now] = distance[current] + 1; //이전 노드의 거리에 + 1
                }
            }
        }
    }

    public static void main(String[] args) {
        FurthestNode f = new FurthestNode();
        System.out.println(f.solution(6,new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}}));
    }
}