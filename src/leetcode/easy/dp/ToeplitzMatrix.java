package leetcode.easy.dp;

/**
 * Given an m x n matrix, return true if the matrix is Toeplitz.
 * Otherwise, return false.
 *
 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same elements.
 *
 *Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * Output: true
 * Explanation:
 * In the above grid, the diagonals are:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]".
 * In each diagonal all elements are the same, so the answer is True.
 */
public class ToeplitzMatrix {
    //오른쪽 아래 방향으로 대각선들에 위치한 값들이 같으면 true, 아니면 false
    public boolean isToeplitzMatrix(int[][] matrix) {
        // [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
        for(int i=0; i<matrix.length-1; i++){
            for(int j=0; j<matrix[0].length-1; j++){
                if (i >=0 && j>=0 && matrix[i][j] != matrix[i+1][j+1]){
                    return false;
                }
            }
        }

        return true;
    }
}
