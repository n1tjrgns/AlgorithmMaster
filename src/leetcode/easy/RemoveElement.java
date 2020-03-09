package leetcode.easy;

import java.util.Arrays;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {

        int index = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val){
                nums[index] = nums[i];
                index++;
                System.out.println(Arrays.toString(nums));
            }

        }
        return index;
    }

    public static void main(String[] args) {
        RemoveElement r = new RemoveElement();
        System.out.println(r.removeElement(new int[]{3,2,2,3}, 2));
    }
}
