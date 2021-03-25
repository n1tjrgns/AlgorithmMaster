package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

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

    public int subarraySumWithHash(int[] nums, int k) {
        int cnt=0;
        int sum=0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        System.out.println("map = " + map);
        for(int i=0; i<nums.length; i++){
            sum+=nums[i];
            System.out.println("sum-k = " + (sum - k));
            if (map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            System.out.println("map.put = " + map);
        }
        return cnt;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK s = new SubarraySumEqualsK();
        System.out.println(s.subarraySum(new int[]{1,1,1},2));
        System.out.println(s.subarraySum(new int[]{1,2,3},3));
        System.out.println(s.subarraySumWithHash(new int[]{1,2,3},3));
    }
}
