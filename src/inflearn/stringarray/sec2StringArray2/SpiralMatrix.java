package inflearn.stringarray.sec2StringArray2;

import java.util.ArrayList;
import java.util.List;

//2차원 배열이 있을때 달팽이 모양이로 숫자 리턴하기
// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    private int[] dx = {0,1,0,-1};
    private int[] dy = {1,0,-1,0};
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean visited[][] = new boolean[m][n];

        List<Integer> list = new ArrayList<>();

        int r = 0, c = 0, direction = 0;

        //배열을 전부 돌아야하기 때문에 m * n 번 돌면 된다.
        for(int i=0; i<m*n; i++){
            list.add(matrix[r][c]);
            visited[r][c] = true;
            int nx = r + dx[direction];
            int ny = c + dy[direction];

            if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]){
                r = nx;
                c = ny;
            }else{
                direction = (direction + 1) % 4; //방향이 0부터 시작했기 때문에
                r = r + dx[direction];
                c = c + dy[direction];
            }
        }

        return list;
    }
    public static void main(String[] args) {
        SpiralMatrix s = new SpiralMatrix();
        System.out.println(s.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
}
