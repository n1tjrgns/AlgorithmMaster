package algorithm;

import java.util.ArrayList;
import java.util.List;

//주어진 배열로 만들 수 있는 모든 순열, 같은 길이만 해당함
//중복되지 않은 숫자를 가지고 있을 때 모든 순열 구하기
public class DefaultPermutation {
    public static void main(String[] args) {
        DefaultPermutation d = new DefaultPermutation();
        System.out.println(d.permute(new int[]{1,2,3}));
    }

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
}
