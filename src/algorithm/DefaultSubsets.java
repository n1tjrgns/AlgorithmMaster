package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DefaultSubsets {
    public static void main(String[] args) {
        DefaultSubsets d = new DefaultSubsets();
        System.out.println(d.solution(new int[]{1,2,3}));
    }

    private List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        //오름 차순으로 정렬하고 싶은 경우
        Arrays.sort(nums);
        backtrack(nums, list, new ArrayList<>(), 0);

        return list;
    }

    private void backtrack(int[] nums, List<List<Integer>> list, ArrayList<Integer> tempList, int depth) {
        list.add(new ArrayList<>(tempList)); //맨 앞에 공백[] 값 넣기
        for (int i=depth; i<nums.length; i++){
            tempList.add(nums[i]);
            backtrack(nums, list, tempList, i+1);
            tempList.remove(tempList.size()-1);
        }
    }
}
