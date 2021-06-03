package inflearn.stringarray.sec5;

//섬에서 가장 넓은 영역 찾기
public class MaxAreaOfIsland {
    private int dx[] = {0,0,1,-1};
    private int dy[] = {1,-1,0,0};

    private int witdh = 0;
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int maxWidth = 0;

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if (!visited[i][j] && grid[i][j] == 1){
                    witdh = 0;
                    dfs(i, j, grid, visited, m, n);
                    maxWidth = Math.max(maxWidth, witdh);
                }
            }
        }

        return maxWidth;
    }

    private void dfs(int x, int y, int[][] grid, boolean[][] visited, int m, int n) {
        witdh++;
        visited[x][y] = true;

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && ny >=0 && nx <m && ny <n){
                if (grid[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny, grid, visited, m, n);
                }
            }
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        System.out.println(m.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0},{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
}


