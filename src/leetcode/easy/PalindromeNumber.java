/*Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
Follow up:

Coud you solve it without converting the integer to a string?*/
package leetcode.easy;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int reverseNum = 0;
        int num = x;
        if(x < 0){
            return false;
        }else{
            while(x > 0){
                int temp = x % 10;
                x = x / 10;
                reverseNum = (reverseNum * 10) + temp;
            }
            if(num == reverseNum){
                return true;
            }else{
                return false;
            }
        }
    }

    public static void main(String[] args) {
        PalindromeNumber p = new PalindromeNumber();
        System.out.println(p.isPalindrome(10));
    }
}
