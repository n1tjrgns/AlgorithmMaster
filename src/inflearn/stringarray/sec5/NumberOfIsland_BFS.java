package inflearn.stringarray.sec5;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland_BFS {

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
                    bfs(i, j, grid, visited, m, n);
                }
            }
        }

        return cnt;
    }

    private void bfs(int x, int y, char[][] grid, boolean[][] visited, int m, int n) {
        visited[x][y] = true;
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x,y});


        while (!que.isEmpty()){
            int curX = que.peek()[0];
            int cury = que.peek()[1];
            que.poll();

            for(int i=0; i<4; i++){
                int nx = curX + dx[i];
                int ny = cury + dy[i];

                if (nx >=0 && ny >=0 && nx <m && ny <n){
                    if (!visited[nx][ny] && grid[nx][ny] == '1'){
                        que.add(new int[]{nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberOfIsland_BFS n = new NumberOfIsland_BFS();
        System.out.println(n.numIslands(new char[][]{
                {'1','1','1','1','0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        }));
    }
}
