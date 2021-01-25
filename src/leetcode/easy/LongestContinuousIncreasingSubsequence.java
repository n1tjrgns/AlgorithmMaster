package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        //일정한 값 만큼 증가하는 곳 까지의 길이를 구함
        //변함 없으면 0
        //문제를 잘못이해했음, 무조건 같은 간격으로 증가하는 문제임
        int count = 0;
        int answer = 0;
        //1 3 5 4 7
        for(int i=0; i<nums.length; i++){
            if (i==0) count++;
            else{
                if (nums[i] > nums[i-1]){
                    count++;
                }else{
                    answer = Math.max(answer, count);
                    count = 1;
                }
            }
        }

        return Math.max(answer, count);
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence l = new LongestContinuousIncreasingSubsequence();
        System.out.println(l.findLengthOfLCIS(new int[]{1,3,5,4,7}));
    }
}
