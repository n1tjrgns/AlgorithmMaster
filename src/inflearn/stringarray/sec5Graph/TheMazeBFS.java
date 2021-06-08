package inflearn.stringarray.sec5Graph;

import java.util.LinkedList;
import java.util.Queue;

//미로 찾기
//2차원 배열에서 1인 부분은 벽, 0인 부분으로 만 이동할 수 있을때,
// 출발지와 목적지가 주어질 때 갈 수 있는지 없는지 여부 리턴하기
public class TheMazeBFS {

    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    int m,n;
    public boolean hasPath(int[][] maze, int[] start, int[] dest) {
        m = maze.length;
        n = maze[0].length;

        //빠른 탈출
        if (start[0] == dest[0] && start[1] == dest[1]) return true;
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        while (!que.isEmpty()) {
            int[] current = que.poll();

            //4방향 탐색
            for(int i=0; i<4; i++){
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];

                //이동할 수 있는 경우 이동
                while (nx >= 0 && ny >= 0 && nx < m && ny < n && maze[nx][ny] == 0) {
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                }
                //이동할 수 없는 경우 다시 원위치
                nx = nx - dx[i];
                ny = ny - dy[i];
                if (visited[nx][ny]) continue;
                visited[nx][ny] = true;
                if (nx == dest[0] && ny == dest[1]) return true;

                que.add(new int[]{nx, ny});
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TheMazeBFS t = new TheMazeBFS();
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
