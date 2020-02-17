package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class KakaoColoringBookBfs {

    public class Node{

        int x;
        int y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static boolean[][] visited = new boolean[100][100];
    private static int[][] map = new int[100][100];

    private static int sizeCount = 0;

    private static ArrayList<Integer> list = new ArrayList<>();

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    sizeCount = 0;
                    numberOfArea++;
                    System.out.println("numberOfArea : "+ numberOfArea);
                    bfs(i,j,picture,m,n);

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, sizeCount);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private void bfs(int x, int y, int[][] picture, int m, int n) {
        int now = picture[x][y];
        visited[x][y] = true;
        sizeCount++;
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(x,y));

        while(!que.isEmpty()){
            Node current = que.poll();

            for(int i=0; i<4; i++){
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if(nx >= 0 && ny >=0 && nx < m && ny < n){
                    if(picture[nx][ny] == now && !visited[nx][ny]){
                        visited[nx][ny] = true;
                        que.add(new Node(nx, ny));
                        sizeCount++;
                    }
                }
            }
        }

    }




    public static void main(String[] args) {
        KakaoColoringBookBfs k = new KakaoColoringBookBfs();

        int m = 6;
        int n = 4;

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},{0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(k.solution(m,n,picture)));
    }
}

