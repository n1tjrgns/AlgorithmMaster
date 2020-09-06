package leetcode.medium;

/*You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.
Input: nums is [1, 1, 1, 1, 1], S is 3.
Output: 5
Explanation:

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.

Constraints:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.

*/
//https://leetcode.com/problems/target-sum/
public class TargetSum {

    public int findTargetSumWays(int[] nums, int S) {

        return dfs(nums, S, 0, 0);
    }

    private int dfs(int[] nums, int target, int depth, int sum) {
        int count = 0;
        if(nums.length == depth){
            if(target == sum){
                count++;
            }
        }else{
            return dfs(nums, target, depth + 1, sum + nums[depth]) + dfs(nums, target, depth + 1, sum - nums[depth]);
        }

        return count;
    }


    public static void main(String[] args) {
        TargetSum t = new TargetSum();
        System.out.println(t.findTargetSumWays(new int[]{1,1,1,1,1} , 3));
    }
}
