package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate2 {
    public boolean containsDuplicate(int[] nums, int k) {

        //해쉬 맵의 최초의 key값을 put 하는 경우 정상적으로 수행되면 null을 리턴한다.
        //하지만 기존에 key값이 있음에도 불구하고 한 번 더 put을 수행하면??
        //해당 키값의 value를 리턴한다.
        //그렇다면 null이 아니라는건 동일한 값이 들어왔다는 것이다.
        //현재 숫자 - 동일한 값 = k 정답
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            Integer last = map.put(nums[i], i);
            if (last != null && (i-last) <= k){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate2 c = new ContainsDuplicate2();
        System.out.println(c.containsDuplicate(new int[]{1,2,3,1,1}, 3));
    }
}
