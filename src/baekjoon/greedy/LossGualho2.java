package baekjoon.greedy;

import java.util.Arrays;

public class LossGualho2 {
    public static void main(String[] args) {
        String s = "55-50+40";

        String[] arr = s.split("\\-");
        System.out.println(Arrays.toString(arr));

        int result = 0;

        for(int i=0; i<arr.length; i++){

            // + 인것만 남아있을테니 +인 인자 값은 더하기
            String[] arr2 = arr[i].split("\\+");

            int tempSum = 0;
            for(int j=0; j<arr2.length; j++){
                tempSum = tempSum + Integer.parseInt(arr2[j]);
            }
            System.out.println(Arrays.toString(arr2));
            System.out.println(tempSum);

            //맨 처음 값은 무조건 양수 이므로 맨 처음 값만 * -1 통해 +로 변환
            if(i==0){
                tempSum = tempSum * -1;
            }
            result = result - tempSum;
        }
        System.out.println(result);
    }
}
