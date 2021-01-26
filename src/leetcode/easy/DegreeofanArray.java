package leetcode.easy;

import java.util.*;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 *
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * Example 2:
 *
 * Input: nums = [1,2,2,3,1,4,2]
 * Output: 6
 * Explanation:
 * The degree is 3 because the element 2 is repeated 3 times.
 * So [2,2,3,1,4,2] is the shortest subarray, therefore returning 6.
 *
 *
 * Constraints:
 *
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 */
public class DegreeofanArray {
    //가장 많이 등장 한 숫자의 처음 인덱스부터 끝 인덱스까지의 길이
    // 등장한 횟수가 같은 경우 짧은 길이를 리턴
    public int findShortestSubArray(int[] nums) {
        //가장 많이 등장 한 숫자 판별
        //해당 숫자의 끝 인덱스 - 첫 인덱스 구하기
        //숫자가 2개 이상이라면? -> 해당 숫자들의 끝 인덱스 - 첫 인덱스 비교해서 작은거 찾기
        //배열의 길이가 5만이니까 많이 등장 한 숫자가 많을 수록 배열을 n2 으로 돌아야 함

        int answer = 0;

        Map<Integer, Integer> left = new HashMap<>(); //최초 숫자 별 시작 지점 인덱스
        Map<Integer, Integer> right = new HashMap<>(); //숫자 별 맨 마지막 지점 인덱스
        Map<Integer, Integer> count = new HashMap<>();  //각 숫자 별 갯수
        //1,2,2,3,1,4,2 -> 길이 7
        for(int i=0; i<nums.length; i++){
            if (left.get(nums[i]) == null){
                left.put(nums[i], i);
            }
            right.put(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0)+1);
        }
        System.out.println("left = " + left);
        System.out.println("right = " + right);
        System.out.println("count = " + count);

        int max = Collections.max(count.values());
        int length = nums.length;
        List<Integer> list = new ArrayList<>();

        for (Integer key : count.keySet()) {
            if (count.get(key) == max){
                answer = Math.min(length, right.get(key) - left.get(key)+1);
                list.add(answer);
            }
        }

        return Collections.min(list);
    }

    public static void main(String[] args) {
        DegreeofanArray d = new DegreeofanArray();
        System.out.println(d.findShortestSubArray(new int[]{1,2,2,3,1,4,2}));
        System.out.println(d.findShortestSubArray(new int[]{1,2,2,3,1}));
        System.out.println(d.findShortestSubArray(new int[]{1,3,2,2,3,1}));
    }
}
