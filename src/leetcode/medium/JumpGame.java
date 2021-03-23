package leetcode.medium;

//https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] nums) {
        int last = nums.length-1;
        for(int i=nums.length-1; i>=0; i--){
            if (nums[i]+i >= last){
                last = i;
            }
        }

        return last == 0;
    }

    public static void main(String[] args) {
        JumpGame j = new JumpGame();
        System.out.println(j.canJump(new int[]{2,3,1,1,4}));
    }
}
