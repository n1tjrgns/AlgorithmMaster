package leetcode.easy;

public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {

        if(nums.length == 0){
            return 0;
        }

        int i = 0;
        for(int j=1; j<nums.length; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
        }

        return i+1;
    }

    public static void main(String[] args) {
        RemoveDuplicatesfromSortedArray r = new RemoveDuplicatesfromSortedArray();
        System.out.println(r.removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4}));
    }
}
