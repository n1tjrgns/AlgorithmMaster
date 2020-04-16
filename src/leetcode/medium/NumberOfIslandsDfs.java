package leetcode.medium;

public class NumberOfIslandsDfs {
    //1로만 둘러 쌓인 구역의 갯수를 구하는 문제
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};


    public int numIslands(char[][] grid) {
        // grid가 0이 아니고 방문 안했으면 dfs를 계속하고
        // dfs 하기 전에 ++ 해주면 끝일듯?

        //빠른 탈출
        if(grid.length == 0){
            return 0;
        }

        int area = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] != '0' && !visited[i][j]){
                    area++;
                    dfs(i,j,grid,visited,m,n);
                }
            }
        }

        return area;
    }

    private void dfs(int x, int y, char[][] grid, boolean[][] visited, int m, int n) {
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && ny >= 0 && nx < m && ny < n){
                if(grid[nx][ny] != '0' && !visited[nx][ny]){
                    dfs(nx,ny,grid,visited,m,n);
                }
            }
        }

    }

    public static void main(String[] args) {
        NumberOfIslandsDfs n = new NumberOfIslandsDfs();
        //char[][] grid = {{'1', '1', '1', '1' ,'0'}, {'1', '1', '0', '1', '0'}, {'1','1','0','0','0'},{'0','0','0','0','0'}};
        
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(n.numIslands(grid));

    }
}
