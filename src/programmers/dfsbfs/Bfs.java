//https://www.acmicpc.net/problem/1260
package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class Bfs {
    static int n;
    static int m;
    static int v;
    static  int [][] graph;
    static boolean[] visited;
    //인접행렬을 사용한 풀이
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //정점의 개수
        m = sc.nextInt(); //간선의 개수
        v = sc.nextInt(); //탐색을 시작할 정점의 번호
        graph = new int[1001][1001]; //정점을 나타낼 행렬, 정점의 개수만큼
        visited = new boolean[10001]; //모든 간선을 다 체크해야하니 간선의 길이만큼
        //방문 여부를 체크
        int v1;
        int v2;
        for(int i=0; i<m; i++){
            v1 = sc.nextInt();
            v2 = sc.nextInt();
            graph[v1][v2] = graph[v2][v1] = 1;
        }
        bfs(v);
    }
    private static void bfs(int v) {
        Queue<Integer> que = new LinkedList<>();
        que.offer(v);
        visited[v] = true; //방문했으니 true
        System.out.println(v+" ");

        int temp;
        while(!que.isEmpty()){
            temp = que.poll();
            for(int i=0; i<n+1; i++){
                if(graph[v][i] == 1 && visited[i] == false){
                    que.offer(i);
                    visited[i] = true;
                    System.out.println(i+ " ");
                }
            }
        }
        for(int i=0; i<n; i++){
            if(graph[v][i] == 1 && visited[i] == false){
                bfs(i);
            }
        }
    }
}