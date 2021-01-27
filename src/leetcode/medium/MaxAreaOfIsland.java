package leetcode.medium;

public class MaxAreaOfIsland {

    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};

    private int count=0;
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        System.out.println("grid = " + grid.length);
        System.out.println("grid = " + grid[0].length);

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    count=0;
                    dfs(i,j,grid,visited,grid.length,grid[0].length);
                    maxArea = Math.max(maxArea, count);
                }
            }
        }
        return maxArea;
    }

    private void dfs(int x, int y, int[][] grid, boolean[][] visited, int m, int n) {
        visited[x][y] = true;
        count++;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < m && ny < n){
                if (grid[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny,grid,visited,m,n);
                }
            }
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland m = new MaxAreaOfIsland();
        System.out.println(m.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
}
