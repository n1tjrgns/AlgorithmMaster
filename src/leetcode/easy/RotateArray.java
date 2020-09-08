package easy;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public int[] rotate(int[] nums, int k) {
        k = k % nums.length; // k가 0이면 결국 한 바퀴이기 때문에 안움직여도됨
        // 1 2 3 4 5 -> 3 -> 34512
        //              2 -> 4512
        //k = 3
        /* 0 + 3
        num[3 % 5] 3    1
        num[4 % 5] 4    2
        num[5 % 5] 0    3
        num[6 % 5] 1    4
        num[7 % 5] 2    5
        * */
        //정말 기발한 방법이지만 어쨌든 주어진 배열의 길이만큼 전부 다 돌아야하기 때문에 탈락
        int temp [] = nums.clone();
        for(int i=0; i<nums.length; i++){
            nums[(i+k)%nums.length] = temp[i];
        }

        // 5 2 3 4 1    1 3
        // 5 4 3 2 1    2 2

        // 3 4 5 2 1    1 1

        // 3 4 5 1 2    4 3
        //전체 배열을 한번 뒤집고, 원하는 위치 전까지만 뒤집고, 원하는 위치에서 끝까지 뒤집고 총 3번 뒤집는다.
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k-1, nums.length-1);

        /* 3 -> num[0] = 5

        * */
        while(k-->0){
            int tmp = nums[nums.length-1];
            System.out.println("tmp : "+tmp);
            for(int i = nums.length-1; i>0; i--){
                nums[i] = nums[i-1];
                System.out.println("nums[i] : " + nums[i]);
            }
            nums[0] = tmp;
            System.out.println("nums[0] : " + nums[0]);
        }

        return nums;
    }

    //이미 뒤집어진것을 또 뒤집는것을 방지하기 위해서 마지막에 start++, end--
    private void reverse(int[] nums, int start, int end) {
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        RotateArray r = new RotateArray();
        System.out.println(Arrays.toString(r.rotate(new int[]{1,2,3,4,5,6,7},3)));
    }
}
