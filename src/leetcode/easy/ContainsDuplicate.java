package leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) return true;
        }

        return false;
    }

    public boolean fasterAnswer(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate c = new ContainsDuplicate();
        System.out.println(c.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(c.containsDuplicate(new int[]{1,2,3,1}));
    }
}
