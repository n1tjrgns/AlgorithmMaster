package remindprogrammers.dfsbfs;

import java.util.Arrays;

public class ColoringBook {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};

    private boolean[][] visited = new boolean[100][100];
    private int[][] map = new int[100][100];
    private int count = 0;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0; //해당 영역의 넓이
        int maxSizeOfOneArea = 0; //가장 큰 영역의 넓이

        map = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && picture[i][j] != 0){
                    count = 0;
                    numberOfArea++;

                    dfs(i, j, visited, picture, m, n);

                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, count);
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private void dfs(int x, int y, boolean[][] visited, int[][] picture, int m, int n) {
        int now = picture[x][y];
        visited[x][y] = true;
        count++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                if (!visited[nx][ny] && picture[nx][ny] == now){
                    dfs(nx,ny,visited,picture,m,n);
                }
            }
        }
    }

    public static void main(String[] args) {
        ColoringBook k = new ColoringBook();
        int m = 6;
        int n = 4;

        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1},{0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(k.solution(m,n,picture)));
    }
}
