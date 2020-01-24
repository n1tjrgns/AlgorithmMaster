/*Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
참고 :
32 비트 부호있는 정수 범위 [-2 31 , 2 31-1  ] 내의 정수만 저장할 수있는 환경을 처리한다고 가정합니다 . 이 문제의 목적을 위해, 역 정수가 오버 플로우 될 때 함수가 0을 리턴한다고 가정하십시오.*/
package leetcode.easy;

public class ReverseInteger {
    public int reverse(int x) {
        // 이런게 있네?
        // System.out.println( Integer.MAX_VALUE ); // 2147483647

        long result = 0;

        while(x !=0 ){
            result = (result * 10) + x % 10;
            x = x / 10;
        }

        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }else{
            return (int)result;
        }


    }

    public static void main(String[] args) {
        ReverseInteger r = new ReverseInteger();
        System.out.println(r.reverse(-123));
    }
}
