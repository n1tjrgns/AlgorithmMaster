package leetcode.medium;

import java.util.*;

/**
 * https://leetcode.com/problems/product-of-array-except-self/
 * Given an array nums of n integers where n > 1,
 * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Example:
 *
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array (including the whole array) fits in a 32 bit integer.
 *
 * Note: Please solve it without division and in O(n).
 *
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductofArrayExceptSelf {

    //배열 안의 수를 조합하여 곱해서 나올 수 있는 수 중에서, 기존 배열의 값과 같지 않은 수만 출력
    //시간 복잡도 O(n)

    //1* 왼쪽에서 쭉, 1 * 오른쪽부터 쭉쭉
    // 1    2   3   4       nums
    // 1*1 1*1  2*1 3*2     계산과정
    // 1    1   2   6       result
    // 24   12  8   6        right 1

    //어떻게 이런 원리지??
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }
        System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
                                // res = 1, 1, 2, 6
                                //  i     : 3               2           1           0
            res[i] *= right;    // res[3] : 6*1     res[2] : 2*4    res[1] : 1*12   res[0] : 1*24
            right *= nums[i];   // right  : 1*4     right : 4*3     right : 12*2    24*1
        }
        return res;
    }

    public static void main(String[] args) {
        ProductofArrayExceptSelf p = new ProductofArrayExceptSelf();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
