package programmers.dfsbfs;

import java.util.Arrays;

public class KakaoColoringBookDfs {

    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};

    private int count = 0; //영역을 카운트 할 변수


    public int[] solution(int m, int n, int[][] picture) {

        int numberOfArea = 0;   //서로 다른 영역의 개수
        int maxSizeOfOneArea = 0;   //가장 큰 영역의 넓이

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    count = 0; //새로운 영역을 들어가면 카운트 초기화
                    numberOfArea++; //새로운 영역 카운트
                    dfs(i,j,picture,visited,m,n);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count); //max 값 비교
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;


    }

    private void dfs(int x, int y, int[][] picture, boolean[][] visited, int m, int n) {
        visited[x][y] = true;
        int current = picture[x][y];
        count++; //넓이++

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(m >0 && n > 0 && nx <= m && ny <= n){
                if(picture[nx][ny] == current && !visited[nx][ny]){
                    dfs(nx,ny, picture, visited, m, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        KakaoColoringBookDfs k = new KakaoColoringBookDfs();

        int m = 6;
        int n = 4;

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},{0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(k.solution(m,n,picture)));
    }
}