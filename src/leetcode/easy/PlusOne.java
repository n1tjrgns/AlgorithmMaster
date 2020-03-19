package leetcode.easy;
/*Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.*/
import java.util.Arrays;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1; i>=0; i--){
            // 9미만이면 + 1
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }

            // 9면 해당 자리를 계속 0으로 만들어준다 -> 10이기 때문에
            digits[i] = 0;
        }

        //새로운 배열을 생성해 맨 앞자리를 1로 바꿔준다.
        int[] arr = new int[digits.length+1];
        arr[0] = 1;

        return arr;
    }

    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        System.out.println(Arrays.toString(p.plusOne(new int[]{1, 2, 3})));
    }
}
