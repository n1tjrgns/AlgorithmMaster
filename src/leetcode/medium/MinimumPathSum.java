package leetcode.medium;

/**
 * https://leetcode.com/problems/minimum-path-sum/
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 * Output: 7
 * Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 * Example 2:
 *
 * Input: grid = [[1,2,3],[4,5,6]]
 * Output: 12
 *
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 100
 */
public class MinimumPathSum {
    //음수가 아닌 2차원 배열
    //아래, 오른쪽으로만 이동 가능
    //숫자의 합 최소인 경우

    //재귀 풀이 -> 시간 초과
    public int minPathSumRecursive(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        //배열과, 가로, 세로 값을 넘김
        return min(grid, height-1, width-1);
    }

    //아래 오른쪽이라고 해도 결국 모든 경로를 탐색해야한다.
    private int min(int[][] grid, int row, int col) {
        if (row == 0 && col ==0) return grid[row][col]; //가로, 세로가 0 -> 길이가 없음 빠른 탈출
        if (row == 0) return grid[row][col] + min(grid, row, col-1); //세로가 0인 경우에는 가로축만 -1 로 변화시키면서 진행
        if (col == 0) return grid[row][col] + min(grid, row-1, col); //가로가 0인 경우
        return grid[row][col] + Math.min(min(grid, row, col-1), min(grid, row-1, col)); //나머지는 둘 중 작은거
    }

    //DP풀이
    public int minPathSum(int[][] grid){
        int height = grid.length;
        int width = grid[0].length;

        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
                if (i==0 && j==0) grid[i][j] = grid[i][j];
                else if(i==0) grid[i][j] = grid[i][j] + grid[i][j-1];
                else if(j==0) grid[i][j] = grid[i][j] + grid[i-1][j];
                else grid[i][j] = grid[i][j] + Math.min(grid[i][j-1] ,grid[i-1][j]);
            }
        }

        return grid[height-1][width-1];
    }

    //위의 케이스는 시간초과
    public static void main(String[] args) {
        MinimumPathSum m = new MinimumPathSum();
        //System.out.println(m.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
        //System.out.println(m.minPathSum(new int[][]{{1,2,3},{4,5,6}}));
        System.out.println(m.minPathSum(new int[][]{{1,2,5},{3,2,1}}));
    }
}
