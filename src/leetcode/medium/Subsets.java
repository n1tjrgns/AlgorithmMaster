package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**https://leetcode.com/problems/subsets/
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3]
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * Example 2:
 *
 * Input: nums = [0]
 * Output: [[],[0]]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * All the numbers of nums are unique.
 */
public class Subsets {
    //배열이 주어질때 배열로 만들수 있는 모든 집합 구하기
    //순열이긴한데, 각 원소로 만들 수 있는 모든 경우의 수를 구하는 문제였음
    //0개, 1개, 2개 ... nums.length일 때까지 집합 구하
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list , List<Integer> tempList, int [] nums, int start){
        list.add(new ArrayList<>(tempList));
        System.out.println("list = " + list);
        for(int i = start; i < nums.length; i++){
            System.out.println("i = " + i);
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 아 0일때 0 1 2에 대한 각각의 backtrack이 전부 다 도는거임;;
     *  list     :      {}  {},1    {},1,{1,2}
     *  templist :      1   1,2     1,2,3       1,3
     *  nums[i]  : 0
     *  start    : 0    1   2       3
     * */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        // Arrays.sort(nums); // not necessary
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new ArrayList<>(tempList));
        } else{
            for(int i = 0; i < nums.length; i++){
                if(tempList.contains(nums[i])) continue; // element already exists, skip
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Subsets s = new Subsets();
        System.out.println(s.subsets(new int[]{1,2,3}));

        System.out.println(s.permute(new int[]{1,2,3}));
    }
}
