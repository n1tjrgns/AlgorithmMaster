package leetcode.easy;
//https://leetcode.com/problems/house-robber/
public class HouseRobber {
    //연속하지 않은 수의 합의 경우의 수 중 큰 수 구하기
    public int rob(int[] nums) {
        //두 칸만 띄워서 계산했더니
        //아예 멀리 떨어져있는 경우를 생각 못함.
        //인접하지 않은 모든 수를 더해봐야함, DP문제

        return rob(nums, nums.length-1);
    }

    private int rob(int[] nums, int i) {
        if(i < 0){
            return 0;
        }

        return Math.max(rob(nums, i-2) + nums[i], rob(nums, i-1));
    }

    public static void main(String[] args) {
        HouseRobber h= new HouseRobber();
        System.out.println(h.rob(new int[]{1,2,3,1}));
        //System.out.println(h.rob(new int[]{2,7,9,3,1}));
    }
}
