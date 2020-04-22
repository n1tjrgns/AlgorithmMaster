package algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

    private int v; //정점 개수
    private LinkedList<Integer>[] adList; // 정점의 인접한 노드를 LinkedList로 저장

    public BFS(int v){
        this.v = v;
        adList = new LinkedList[v];

        //정점 갯수만큼 초기화
        for(int i=0; i<v; i++){
            adList[i] = new LinkedList<>();
        }
    }

    //간선을 서로 연결
    public void connect(int x, int y){
        adList[x].add(y);
        adList[y].add(x);
    }

    // 시작점을 받아서 bfs start
    public void bfsSolution(int start){
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[v];

        que.add(start); //시작점 넣고
        visited[start] = true; // 방문 체크하고

        while(!que.isEmpty()){
            int current = que.poll();

            System.out.println(current);

            for(int i=0; i< adList[current].size(); i++){ // 시작점과 인접한 노드의 개수만큼 반복
                int now = adList[current].get(i);

                System.out.println("now : " + now);

                if(!visited[now]){
                    visited[now] = true;
                    que.add(now);
                }
            }
        }
   }


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BFS bfs = new BFS(5);

        bfs.connect(0, 1);
        bfs.connect(0, 2);
        bfs.connect(1, 3);
        bfs.connect(2, 4);

        bfs.bfsSolution(0);
    }
}