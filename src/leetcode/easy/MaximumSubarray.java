package leetcode.easy;

//배열에서 인접한 수를 더해서 가장 큰 값을 구하는 DP 문제
//시간 복잡도 O(n)
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int lastMax = nums[0];

        for(int i=1; i<nums.length; i++){
            lastMax = Math.max(lastMax+nums[i], nums[i]);
            System.out.println("lastMAx : "+ lastMax);
            max = Math.max(max, lastMax);
            System.out.println("max : "+ max);
        }

        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray m = new MaximumSubarray();
        System.out.println(m.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
