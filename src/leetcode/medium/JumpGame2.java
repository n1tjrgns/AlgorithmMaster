package leetcode.medium;

/**
 * https://leetcode.com/problems/jump-game/
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */
public class JumpGame2 {
    //자기 자신보다 값이 커야지만 점프해서 이동할 수 있고, 이동 거리에 제한은 없는듯
    //무조건 끝에 도착함.
    public int jump(int[] nums) {
        //우선 값이 같은 경우는 제외하고 풀어보자
        int cnt=0;
        int curEnd=0;
        int curFarthest=0;
        for(int i=0; i<nums.length-1; i++){ //맨 마지막 인덱스는 이미 도착한 뒤이기 때문에 더 돌 필요가 없음
            // 인덱스 i + 인덱스에서 가장 멀리 갈 수 있는 수 nums[i]
            curFarthest = Math.max(curFarthest, i+nums[i]); //현재 위치에서 인덱스 만큼 가장 멀리갈 수 있는 수 구하기
            if (i == curEnd){
                cnt++;
                curEnd = curFarthest;
            }
        }

        return cnt;
    }

    public static void main(String[] args) {
        JumpGame2 j = new JumpGame2();
        System.out.println(j.jump(new int[]{2,3,1,1,4}));
    }
}
