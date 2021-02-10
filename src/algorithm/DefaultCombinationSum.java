package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//중복을 고려하지 않고 더해서 구할 수 있는 모든 경우의 수 찾기
public class DefaultCombinationSum {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(result, nums, new ArrayList<>(), target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] nums, ArrayList<Integer> tempList, int target, int start) {
        if (target < 0) return;
        else if (target == 0) result.add(new ArrayList<>(tempList));
        else{
            for(int i=start; i<nums.length; i++){
                tempList.add(nums[i]);
                backtrack(result, nums, tempList, target - nums[i], i);
                tempList.remove(tempList.size()-1);
            }
        }

    }


    private void backtrackCantReUseSameElement(List<List<Integer>> result2, int[] nums, ArrayList<Integer> tempList, int target, int start) {
        if (target < 0) return;
        if (target == 0) result2.add(new ArrayList<>(tempList));
        else{
            for(int i=start; i<nums.length; i++) {
                if (i>start && nums[i] == nums[i-1]) continue; //skip duplicate
                tempList.add(nums[i]);
                backtrackCantReUseSameElement(result2, nums, tempList, target - nums[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        DefaultCombinationSum d = new DefaultCombinationSum();
        System.out.println(d.combinationSum(new int[]{2,3,6,7},7));
    }

}
