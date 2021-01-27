package leetcode.easy;

/**
 * https://leetcode.com/problems/find-pivot-index/
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of all the numbers to the left of the index is equal to the sum of all the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,7,3,6,5,6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 *
 * Constraints:
 *
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class FindPivotIndex {
    //피벗 인덱스 = 왼쪽 인덱스의 합과 오른쪽 인덱스의 합이 같은 경우 그 가운데에 있는 인덱스
    //해당하는 케이스가 없는 경우 -1 리턴 한다.
    //몇번째 있는 인덱스가 피벗에 해당하는지를 리턴
    //0번 인덱스와 맨 마지막 인덱스는 피벗이 될 수 없다.
    public int pivotIndex(int[] nums) {
        // n=1 부터 nums.length-2 까지 좌 우 합이 같아야함
        //내가 푼 풀이 -> 너무 느림
        for(int i=0; i<nums.length; i++){
            int left=0, right=0;
            for(int j=0; j<nums.length; j++){
                if (i==j) continue;
                if (i>j) left = left+nums[j];
                if (i<j) right = right+nums[j];
            }
            if (left == right) return i;
        }

        return -1;
    }

    public int pivotIndex2(int[] nums){
        int sum=0, leftsum=0;
        for (int num : nums) {
            sum = sum + num;
        }
        for(int i=0; i<nums.length; i++){
            //오른쪽 = 전체 - 왼쪽 - 피봇
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum = leftsum+nums[i];
        }

        return -1;
    }
    //2중 for문을 for문 1개로 끝냈네
    /**
     *  public int pivotIndex(int[] nums) {
     *         int sum = 0, leftsum = 0;
     *         for (int x: nums) sum += x; //전체 합을 미리 구함
     *         for (int i = 0; i < nums.length; ++i) {
     *             if (leftsum == sum - leftsum - nums[i]) return i;
     *             leftsum += nums[i];
     *         }
     *         return -1;
     *     }
     *
     *
     */

    public static void main(String[] args) {
        FindPivotIndex f = new FindPivotIndex();
        System.out.println(f.pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(f.pivotIndex(new int[]{1,2,3}));
        System.out.println(f.pivotIndex(new int[]{-1,-1,-1,0,1,1}));
    }
}
