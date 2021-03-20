package leetcode.medium;

import java.util.Arrays;

/**https://leetcode.com/problems/sort-colors/
 * Given an array nums with n objects colored
 * red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * Example 2:
 *
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * Example 3:
 *
 * Input: nums = [0]
 * Output: [0]
 * Example 4:
 *
 * Input: nums = [1]
 * Output: [1]
 */
public class SortColors {
    //0 1 2
    //red white blue
    public void sortColors(int[] nums) {
        //Arrays.sort(nums); 물론 이렇게 할 수 있겠지만 코테에서 원하는건 이게 아님.
        //처음 끝 부분을 잡고,
        //처음 끝을 비교 후 숫자가 같지 않으면 자리를 바꾸고 앞의 경우 인덱스 ++, 뒤는 --
        //0과 2만 계속해서 비교하면서 바꿔나가다보면 1은 자연스럽게 자리가 밀리게됨.

        if (nums == null || nums.length == 1) return;

        int low = 0;
        int max = nums.length-1;

        for(int i=low; i<=max;){
            if (nums[i] == 0){
                if (nums[low] !=0){
                    int temp = nums[i];
                    nums[i] = nums[low];
                    nums[low] = temp;
                }
                i++; low++;
            }else if (nums[i] == 2){
                if (nums[max] != 2) {
                    int temp = nums[i];
                    nums[i] = nums[max];
                    nums[max] = temp;
                }
                max--;
            }else{
                i++;
            }
        }

        /*for(int i=0; i<nums.length; i++){
            System.out.println(nums[i]);
        }*/
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        SortColors s = new SortColors();
        s.sortColors(new int[]{2,0,2,1,1,0});
    }
}
