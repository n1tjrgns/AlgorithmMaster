package leetcode.medium;

import java.util.Arrays;

/**
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly.
 *
 * DO NOT allocate another 2D matrix and do the rotation.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[7,4,1],[8,5,2],[9,6,3]]
 * Example 2:
 *
 *
 * Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
 * Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 * Example 3:
 *
 * Input: matrix = [[1]]
 * Output: [[1]]
 * Example 4:
 *
 * Input: matrix = [[1,2],[3,4]]
 * Output: [[3,1],[4,2]]
 *
 *
 * Constraints:
 *
 * matrix.length == n
 * matrix[i].length == n
 * 1 <= n <= 20
 * -1000 <= matrix[i][j] <= 1000
 */
public class RotateImage {
    /*
     *  1 2 3               7 4 1       0,0 -> 2,0  0,1 -> 2,1  2,0 -> 2,2
     *  4 5 6       ->      8 5 2       0,1 -> 1,0  1,1 -> 1,1  2,1 -> 1,2
     *  7 8 9               9 6 3       0,2 -> 0,0  1,2 -> 0,1  2,2 -> 2,0
     */
    //2차원 배열이 주어졌을 때, 90도 회전시키기, 새로운 2차원 배열을 만들면 안되고 현재 배열만 가지고 진행해야함.
    //다음 숫자를 기존 위치에 저장하면서 이동해야하기 때문에 인덱스를 한 지점으로 부터 시계방향으로 오도록 숫자를 고려해야함.
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        //n : 3         4
        //i : 0 1
        //j : 0 0
        for(int i=0; i<(n+1)/2; i++){ //2       2
            for(int j=0; j<n/2; j++){ //1       2
                int temp = matrix[n-1-j][i]; //2,0 -> 3     2,1 - > 6
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j]; //2,2 -> 9     1,2 -> 8
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i]; //0,2 -> 7     0,1 -> 4
                matrix[j][n-1-i] = matrix[i][j]; //0,0 -> 1         1,0 -> 2
                matrix[i][j] = temp;
            }
        }

        for(int i=0; i<(n+1)/2; i++){
            for(int j=0; j<n/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }


    }

    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        r.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
