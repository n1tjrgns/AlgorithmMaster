package leetcode.medium;
//https://leetcode.com/problems/number-of-islands/
/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3*/
public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        if(grid.length == 0 || grid == null){
            return 0;
        }

        boolean[][] visited;
        int part = 0;
        int gridLen = grid.length;
        int grid0 = grid[0].length;


        visited = new boolean[gridLen][grid0];
        int[][] island = new int[gridLen][grid0];

        for(int i=0; i<gridLen; i++){
            for(int j=0; j<grid0; j++){
                island[i][j] = grid[i][j] - '0';
            }
        }

        for(int i=0; i<gridLen; i++){
            for(int j=0; j<grid0; j++){
                if(island[i][j] == 1 && !visited[i][j]){
                    part++;
                    dfs(i,j,island,gridLen,grid0,visited);
                }
            }
        }
        return part;
    }

    private void dfs(int x, int y, int[][] island, int gridLen, int grid0, boolean[][] visited) {
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};

        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >=0 && nx < gridLen && ny < grid0){
                if(island[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny,island,gridLen,grid0,visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIslands n = new NumberOfIslands();

        char[][] grid = {{'1'},{'1'}};
                //{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};

        System.out.println(n.numIslands(grid));
    }
}
