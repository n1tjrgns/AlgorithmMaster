package leetcode.medium;

import java.util.Arrays;

//https://leetcode.com/problems/product-of-array-except-self/discuss/135882/A-Java-solution-with-an-explanation
public class ProductOfArrayExceptSelfRemind {
    //자기 자신을 제외한 나머지 수들의 곱한
    //자기 자신을 기준으로 왼쪽 곱과 오른쪽 곱을 나눠서 연산해 시간 복잡도를 최소화시킨다.
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        left[0] = 1;
        for(int i=1; i<nums.length; i++){
            left[i] = left[i-1] * nums[i-1];
        }

        right[nums.length-1] = 1;
        for(int i=nums.length-2; i>=0; i--){
            right[i] = right[i+1] * nums[i+1];
        }

        int result[] = new int[nums.length];
        for(int i=0; i<result.length; i++){
            result[i] = left[i] * right[i];
        }

        return result;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelfRemind p = new ProductOfArrayExceptSelfRemind();
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(p.productExceptSelf(new int[]{-1, -1, 0, -3, 3})));
    }
}
