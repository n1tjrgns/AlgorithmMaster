package leetcode.medium;

public class UniquePaths {
    public int uniquePaths(int  m, int n) {
        /**
         * 피보나치 처럼 첫 가로 세로줄을 1로 초기화 해놓고
         * 위, 왼쪽을 더한 값을 쌓아서 마지막 행렬부분에 값을 구하면 됨.
         */
        int[][] grid = new int[m][n];
        for(int i=0; i<m; i++){
            grid[i][0] = 1;
        }

        for(int j=0; j<n; j++){
            grid[0][j] = 1;
        }

        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        }

        return grid[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
        System.out.println(u.uniquePaths(3,7));
    }
}
