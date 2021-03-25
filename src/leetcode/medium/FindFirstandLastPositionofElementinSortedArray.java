package leetcode.medium;

import java.util.Arrays;

public class FindFirstandLastPositionofElementinSortedArray {
    // 배열은 오름차순으로 정렬되어있음.
    // target에 해당하는 값을 찾아서 인덱스의 처음과 끝 인덱스를 배열에 담아서 리턴하면 된다.
    // 시간복잡도를 o log n에 풀어야함.
    // 퀵 정렬 문제.
    public int[] searchRange(int[] nums, int target) {
        int[] answer = new int[2];
        answer[0] = findFirst(nums, target);
        answer[1] = findLast(nums, target);

        return answer;
    }

    private int findFirst(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (start + end)/2;
            if (nums[mid] >= target){
                end = mid -1;
            }else{
                start = mid + 1;
            }

            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    private int findLast(int[] nums, int target) {
        int index = -1;
        int start = 0;
        int end = nums.length-1;
        while (start <= end){
            int mid = (start + end)/2;
            if (nums[mid] <= target){
                start = mid + 1;
            }else{
                end = mid - 1;
            }

            if (nums[mid] == target) index = mid;
        }
        return index;
    }

    public static void main(String[] args) {
        FindFirstandLastPositionofElementinSortedArray f = new FindFirstandLastPositionofElementinSortedArray();
        System.out.println(Arrays.toString(f.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
    }
}
