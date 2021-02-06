package leetcode.easy;

import java.util.Arrays;

/**https://leetcode.com/problems/move-zeroes/
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 *
 * Example:
 *
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 *
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class MoveZeroes {
    //주어진 배열에서 0을 젤 뒤로 보내기
    //0으로 다 채워놓고, 0 아닌걸 차례대로 배열에 넣으면 되지않을까?
    public void moveZeroes(int[] nums) {
        nums = new int[]{0, 1, 0, 3, 12};
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 0);

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                answer[index++] = nums[i];
            }
        }

        for (int i=0; i<answer.length; i++){
            nums[i] = answer[i];
        }
        //return answer;
    }

    public static void main(String[] args) {
        MoveZeroes m = new MoveZeroes();
        //System.out.println(Arrays.toString(m.moveZeroes(new int[]{0, 1, 0, 3, 12})));
    }
}
