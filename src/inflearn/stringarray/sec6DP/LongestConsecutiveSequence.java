package inflearn.stringarray.sec6DP;

import java.util.Arrays;

//https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {

    //같은 증가액만큼 가장 길이가 긴 구간의 길이를 구하라
    //근데 시퀀스라서 1만큼 증가하는걸 체크해야함, 문제 이상함
        public int longestConsecutive (int[] nums){
            if (nums == null || nums.length == 0) return 0;
            Arrays.sort(nums);

            int current = nums[0];
            int count = 1;
            int ans = 1;
            System.out.println("nums = " + Arrays.toString(nums));
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] == nums[i-1]) continue;
                if (nums[i] == current + 1) {
                    System.out.println("i = "+ i +" :: nums[i] = " + nums[i] + " ::  + current+1 = " + (current+1));
                    current++;

                    count++;
                    System.out.println("count = " + count);
                    ans = Math.max(ans, count);
                    System.out.println("ans = " + ans);
                }else{
                    current = nums[i];
                    count = 1;
                }
            }

            return ans;
        }

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        //System.out.println(l.longestConsecutive(new int[]{100,4,200,1,3,2}));
        //System.out.println(l.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        //System.out.println(l.longestConsecutive(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
        System.out.println(l.longestConsecutive(new int[]{4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3}));
        //System.out.println(l.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
        //System.out.println(l.longestConsecutive(new int[]{0,0}));
    }
}
