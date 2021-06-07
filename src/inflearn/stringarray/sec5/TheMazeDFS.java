package inflearn.stringarray.sec5;

public class TheMazeDFS {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;

        //빠른 탈출
        if (maze == null || maze.length == 0) return false;
        boolean[][] visited = new boolean[m][n];

        //시작점이 주어졌기 때문에 for문을 돌릴 필요가 없네..
        return dfs(visited, start, dest, maze);
    }

    private boolean dfs(boolean[][] visited, int[] start, int[] end, int[][] maze) {

        //유효성 검사
        if (start[0] < 0 || start[1] < 0 || start[0] >=m || start[1] >=n || visited[start[0]][start[1]]){
            return false;
        }

        visited[start[0]][start[1]] = true;

        //빠른 탈출
        if (start[0] == end[0] && start[1] == end[1]) return true;

        for(int i=0; i<4; i++){
            int nx = start[0] + dx[i];
            int ny = start[1] + dy[i];

            while (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == 0) {
                nx = nx + dx[i];
                ny = ny + dy[i];

            }
            nx = nx - dx[i];
            ny = ny - dy[i];
            if (dfs(visited, new int[]{nx,ny},end,maze)){
                return true;
            }
        }

        return false;
        }

    public static void main(String[] args) {
        TheMazeDFS t = new TheMazeDFS();
        int[] start = {0, 4};
        int[] dest = {4, 4};
        int[][] maze =
                {
                        {0, 0, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0},
                        {1, 1, 0, 1, 1},
                        {0, 0, 0, 0, 0}
                };
        System.out.println(t.hasPath(maze, start,dest));
    }
}
