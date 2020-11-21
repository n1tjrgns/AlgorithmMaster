package remindprogrammers;

import java.util.Arrays;

public class TriangleSnail {
    public int[] solution(int n) {
        /**
         *  n에 따른 삼각형의 갯수
         *  n =  1  2   3   4
         *  cnt= 1  3   6   10
         */
        int[][] arr = new int[n][n];
        
        int max = getMax(n);

        //삼각형 모양의 배열을 -1로 초기화
        for(int i=0; i<n; i++){
            for(int j=0; j<= i; j++){
                arr[i][j] = -1;
            }
        }

        int[] answer = new int[max];

        int i=0, j=0, k=1;
        arr[i][j] = k;
        while (k < max){
            while (i+1 < n && arr[i+1][j] == -1){
                arr[++i][j] = ++k;
            }

            while (j+1 < n && arr[i][j+1] == -1){
                arr[i][++j] = ++k;
            }

            while (i-1 > 0 && j-1 > 0 && arr[i-1][j-1] == -1){
                arr[--i][--j] = ++k;
            }
        }

        k=0;

        for(i=0; i<n; i++){
            for(j=0; j<=i; j++){
                answer[k++] = arr[i][j];
            }
        }
        return answer;
    }

    //재귀로 전체 배열의 크기를 구함, 피보나치
   private int getMax(int n) {
        return n == 1 ? 1 : getMax(n-1) + n;
    }

    public static void main(String[] args) {
        TriangleSnail t = new TriangleSnail();
        System.out.println(Arrays.toString(t.solution(3)));
    }
}
