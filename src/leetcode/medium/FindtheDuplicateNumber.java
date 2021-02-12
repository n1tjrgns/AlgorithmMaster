package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**https://leetcode.com/problems/find-the-duplicate-number/
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 *
 * There is only one repeated number in nums, return this repeated number.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * Example 3:
 *
 * Input: nums = [1,1]
 * Output: 1
 * Example 4:
 *
 * Input: nums = [1,1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * 2 <= n <= 3 * 104
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 */
public class FindtheDuplicateNumber {
    //2번 반복되는 요소를 찾아서 출력해라
    //걍 맵에 담으면 끝나는거아닌가?
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for (Integer key : map.keySet()) {
            if (map.getOrDefault(key,0) == 2){
                return key;
            }
        }
        return -1;
    }

    //근데 속도는 Set에 담아서 contains 하고 있는지 체크하는게 더 빠르네
    public int findDuplicate2(int[] nums){
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)){
                return num;
            }
            set.add(num);
        }

        return -1;
    }

    public static void main(String[] args) {
        FindtheDuplicateNumber f = new FindtheDuplicateNumber();
        System.out.println(f.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
