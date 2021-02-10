package algorithm;

import java.util.ArrayList;
import java.util.List;

public class DefaultSubsetsWithDuplicated {
    public static void main(String[] args) {
        DefaultSubsetsWithDuplicated d = new DefaultSubsetsWithDuplicated();
        System.out.println(d.solution(new int[]{1,2,2}));
    }

    private List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //중복된 요소가 포함되기 때문에 오름차순으로 정렬하지 않아도 된다.
        //Arrays.sort(nums);
        backtrack(nums, list, new ArrayList<>(), 0);

        return list;
    }

    private void backtrack(int[] nums, List<List<Integer>> list, ArrayList<Integer> tempList, int start) {
        if (nums.length == tempList.size()){
            list.add(new ArrayList<>(tempList));
        }else {
            for (int i = start; i < nums.length; i++) {
                if (tempList.add(nums[i])) ;
                tempList.add(nums[i]);
                backtrack(nums, list, tempList, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
