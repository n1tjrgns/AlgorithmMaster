package leetcode.easy;

/**
 * https://leetcode.com/problems/island-perimeter/discuss/95001/clear-and-easy-java-solution
 * You are given row x col grid representing a map where grid[i][j] = 1
 * represents land and grid[i][j] = 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water, and there is exactly one island
 * (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes",
 * meaning the water inside isn't connected to the water around the island.
 * One cell is a square with side length 1.
 * The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 *
 */
public class IslandPerimeter {
    //1인 영역의 둘레의 길이를 구하기
    private int[] dx = {0,0,1,-1};
    private int[] dy = {1,-1,0,0};


    public int islandPerimeter(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i=0; i<grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]==1 && !visited[i][j]){
                    return dfs(i,j,visited,grid,grid.length,grid[0].length);
                }
            }
        }

        return 0;
    }

    private int dfs(int x, int y, boolean[][] visited, int[][] grid, int m, int n) {
        System.out.println("dfs start");
        visited[x][y] = true;
        System.out.println("visited[" +x+"]["+y+"] = " + visited[x][y]);
        int count=0;
        System.out.println("x = " + x + " ::: y = " + y);
        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            System.out.println("i = " + i + " ::: nx = " + nx + " ::: ny = " + ny);

            if (nx < 0 || ny < 0 || nx>=m || ny>=n || grid[nx][ny] == 0){
                count++;
            }else {
                if (grid[nx][ny] == 1 && !visited[nx][ny]){
                    count = count + dfs(nx,ny,visited,grid,m,n);
                }
            }
            System.out.println("count = " + count);
        }
        return count;
    }

    public static void main(String[] args) {
        IslandPerimeter i = new IslandPerimeter();
        System.out.println(i.islandPerimeter(new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
    }
}
