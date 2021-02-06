package leetcode.easy;

import java.util.*;

/**https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class FindAllNumbersDisappearedInanArraay {
    // 1부터 배열의 길이까지인 정수 배열이 있는데, 1번 or 2번까지 나올 수 있음
    // 배열의 길이가 8이라면 정수는 1~8까지 있어야한다. 없는 정수를 구해서 리턴해라
    // O(n) 의 시간복잡도 안에 구해야한다.

    //value값이 2인 갯수 만큼 해당 정수가 없을것임
    //map에 다 넣고, key를 get 했을 때 없으면 이전 key 값 + 1을 넣는다?
    public List<Integer> findDisappearedNumbers(int[] nums) {

        int max = nums.length;
        if (max == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        Arrays.sort(new Map[]{map});
        int key = 1;
        do {
            if (map.getOrDefault(key,0) >=1) key++;
            else{
                result.add(key);
                key++;
            }
        }while (key <= max);

        return result;
    }

    //풀어서 맞긴 했으나 문제 의도는 이게 아니었음.
    //정렬을 해서 정렬한 인덱스의 자리에 다른 숫자가 들어있으면 해당 인덱스 자리를 출력하도록 하는게 문제 의도
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> result= new ArrayList<>();
        int max = nums.length;
        for(int i=0; i<nums.length; i++){
            System.out.println("(nums[i]-1) = " + (nums[i]-1));
            nums[(nums[i]-1) % max] = nums[(nums[i]-1) % max] + max;
        }

        for(int i=0; i<nums.length; i++){
            if (nums[i] <= max){
                result.add(i+1);
            }
        }
        return result;
    }

    public List<Integer> findDisappearedNumbers2(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.println("nums[i] = " + nums[i]);
            System.out.println("(nums[i]-1) = " + (nums[i]-1));
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }
        List<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        FindAllNumbersDisappearedInanArraay f = new FindAllNumbersDisappearedInanArraay();
        System.out.println(f.findDisappearedNumbers2(new int[]{4,3,2,7,8,2,3,1}));
        System.out.println(f.findDisappearedNumbers(new int[]{}));
    }
}
