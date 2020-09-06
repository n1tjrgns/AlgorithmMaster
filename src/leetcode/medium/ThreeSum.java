package leetcode.medium;

import java.util.*;

//https://leetcode.com/problems/4sum/
public class ThreeSum {
    //임의의 3가지 수를 더해서 원하는 target이 나오는 집합을 구하기
    //임의의 3점(포인터)를 내가 지정해서 풀이
    //중복되는 케이스 방지
    public List<List<Integer>> threeSum(int[] nums) {
        //-1,0,1,2,-1,-4

        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) return list;
        Arrays.sort(nums);

        //합이 0을 만족하는 3개의 숫자를 구해야 하므로, 3개의 임의의 포인터를 잡는다.
        //여기서는 i와 i+1, 제일 끝점 length -1 로 잡았다.
        for(int i=0; i<nums.length-2; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //만약에 left와 left + 1 이 같다면 다음 사이클에서 중복이 되어버리기 때문에 left++
                    //right 도 마찬가지
                    //그게 아니라면 일반적인 left++, right--
                    while (left + 1 < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (right - 1 > left && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum < 0) {
                    left++;
                }else {
                    right--;
                }
            }

        }
            return list;
    }

    public static void main(String[] args) {
        ThreeSum f = new ThreeSum();
        System.out.println(f.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }
}
