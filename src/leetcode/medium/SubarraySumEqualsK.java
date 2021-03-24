package leetcode.medium;

//https://leetcode.com/problems/subarray-sum-equals-k/solution/
public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int cnt=0;
        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
                if (sum == k) cnt++;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[]{1,1,1},2));
        System.out.println(s.subarraySum(new int[]{1,2,3},3));
    }
}
