package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//중복된 원소를 제외한 target을 만족하는 집합의 합
public class DefaultCombinationSumNotReUseElement {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrackCantReUseSameElement(result, nums, new ArrayList<>(), target, 0);
        return result;
    }

    private void backtrackCantReUseSameElement(List<List<Integer>> result, int[] nums, ArrayList<Integer> tempList, int target, int start) {
        if (target < 0) return;
        else if (target==0) result.add(new ArrayList<>(tempList));
        else{
            for(int i=start; i<nums.length; i++){
                if (i > start && nums[i] == nums[i-1]) continue;
                tempList.add(nums[i]);
                backtrackCantReUseSameElement(result, nums, tempList, target - nums[i], i+1);
                tempList.remove(tempList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        DefaultCombinationSumNotReUseElement d = new DefaultCombinationSumNotReUseElement();
        System.out.println(d.combinationSum(new int[]{2,3,6,7},7));
        System.out.println(d.combinationSum(new int[]{2,3,5},8));
    }
}

