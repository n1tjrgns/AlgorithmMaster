package inflearn.stringarray.sec2;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number)
 * which has the largest sum and return its sum.
 */
public class MaximumSubarray {
    //카데인 알고리즘 문제 (동적계획법)
    //배열의 연속된 수를 더해서 가장 큰 값을 구하기
    public int maxSubArray(int[] nums) {
        //길이가 1인 경우 빠른 리턴
        if (nums.length == 1) return nums[0];

        int max = nums[0];
        int maxEnd = nums[0];

        for(int i=1; i<nums.length; i++){
            maxEnd = Math.max(maxEnd+nums[i], nums[i]); //현재 인덱스와 이전까지 인덱스의 합과 더한 값을 비교하는것
            max = Math.max(max, maxEnd);
            System.out.println("maxEnd = " + maxEnd + " :: max = " + max);
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4})); //6
        //System.out.println(m.maxSubArray(new int[]{5,4,-1,7,8})); //23
    }
}
