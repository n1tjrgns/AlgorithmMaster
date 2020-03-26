package leetcode;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        //많이 나온 수 찾기
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int a : nums){
            if(!map.containsKey(a)){
                map.put(a, 1);
            }else{
                int value = map.get(a) + 1;
                map.put(a, value);
            }
        }

        for(Map.Entry<Integer, Integer> key : map.entrySet()){

            if(map.get(key.getKey()) > nums.length/2){
                return key.getKey();
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        MajorityElement m = new MajorityElement();
        System.out.println("정답 :" + m.majorityElement(new int[]{3,2,3}));
        System.out.println("정답 :" + m.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println("정답 :" + m.majorityElement(new int[]{3,3,4}));
        System.out.println("정답 :" + m.majorityElement(new int[]{6,6,6,7,7}));
        System.out.println("정답 :" + m.majorityElement(new int[]{8,8,7,7,7}));
        System.out.println("정답 :" + m.majorityElement(new int[]{6,5,5}));
    }
}
