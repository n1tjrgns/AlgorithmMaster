package programmers.dfsbfs;

import java.util.ArrayList;
import java.util.Arrays;

//ref : https://twpower.github.io/151-bfs-dfs-basic-problem
public class KakaoColoringBook {

    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private static boolean[][] visited = new boolean[100][100];
    private static int[][] map = new int[100][100];

    private static int count = 0;

    private static ArrayList<Integer> list = new ArrayList<>();

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        map = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //0이 아니고 방문하지 않았다면
                if(picture[i][j] != 0 && !visited[i][j]){
                    count = 0;
                    numberOfArea++; // 방문 구역 ++
                    dfs(i,j,picture,m,n);
                    //한 구역을 탐색이 끝나면 크기 영역 크기 비교
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }

    private void dfs(int x, int y, int[][] picture, int m, int n) {
        int now = picture[x][y];
        visited[x][y] = true;
        count++;
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                if(picture[nx][ny] == now && !visited[nx][ny]){
                    dfs(nx,ny,picture,m,n);
                }
            }
        }
    }

    public static void main(String[] args) {
        KakaoColoringBook k = new KakaoColoringBook();

        int m = 6;
        int n = 4;

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},{0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(k.solution(m,n,picture)));
    }
}
