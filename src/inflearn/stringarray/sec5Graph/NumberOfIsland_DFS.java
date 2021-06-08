package inflearn.stringarray.sec5Graph;

public class NumberOfIsland_DFS {
    //1로만 연결된 영역이 섬이라고 할 때 영역의 개수 카운트 하기
    private int[] dx = {0,0,1,-1};
    private int[] dy = {1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int m = grid.length;
        int n = grid[0].length;

        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    cnt++;
                    dfs(i, j, grid, visited, m, n);
                }
            }
        }

        return cnt;
    }

    private void dfs(int x, int y, char[][] grid, boolean[][] visited, int m, int n) {
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < m && ny <n ){
                if (!visited[nx][ny] && grid[nx][ny] == '1') {
                    dfs(nx, ny, grid, visited, m, n);
                }
            }
        }
    }


    public static void main(String[] args) {
        NumberOfIsland_DFS n = new NumberOfIsland_DFS();
        System.out.println(n.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }
}
