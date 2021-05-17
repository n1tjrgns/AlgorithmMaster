package inflearn.stringarray.sec1;

import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        // 배열안의 숫자를 전체 양수로 생각해서 그 값을 + 1 한 후 다시 배열로 나타내기

        int n = digits.length;
        for(int i=n-1; i>=0; i--){
            if (digits[i] < 9){ //맨 뒷자리가 9가아니면 + 1 후 바로 리턴
                digits[i]++;
                System.out.println("digits = " + Arrays.toString(digits));
                return digits;
            }

            digits[i] = 0; // 9 면 0으로 바꿈
            System.out.println("i=0 digits = " + Arrays.toString(digits));
        }

        //전부다 9로 되어있는 경우에만 여길 타서 맨 앞자리에 + 1 을 해준다.
        int[] answer = new int[n+1];
        answer[0] = 1;

        return answer;
    }

    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        //System.out.println(Arrays.toString(p.plusOne(new int[]{1, 2, 3})));
        //System.out.println(Arrays.toString(p.plusOne(new int[]{4,3,2,1})));
        //System.out.println(Arrays.toString(p.plusOne(new int[]{0})));
        //System.out.println(Arrays.toString(p.plusOne(new int[]{9,9}))); // -> 1,0,0
        //System.out.println(Arrays.toString(p.plusOne(new int[]{4,9,5}))); // -> 1,0,0
        System.out.println(Arrays.toString(p.plusOne(new int[]{2,9}))); // -> 1,0,0
        //System.out.println(Arrays.toString(p.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0}))); // -> 1,0,0
    }
}
