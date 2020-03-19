package leetcode.easy;
/*Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0*/
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {


        /* 나의 풀이
        int i=0;
        for(i=0; i<nums.length; i++){
            if(nums[i] == target){
                return i;
            }else if(nums[nums.length-1] < target){
                return nums.length;
            }else if(target <nums[0]){
                return 0;
            }else if(nums[i] < target && target < nums[i+1]){
                return i+1;
            }
        }

        return i;*/

            //더 간단하게
            for(int i=0; i<nums.length; i++){
                if(target<=nums[i]){
                    return i;
                }
            }
            return nums.length;
    }

    public static void main(String[] args) {
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[]{1}, 2));
    }
}
