package inflearn.stringarray.sec1;

import java.util.Arrays;

public class TwoSum {
    //두 수를 더해서 target이 나오는 index를 반환하는 문제
    public int[] twoSum(int[] nums, int target) {

        for(int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum.twoSum(new int[]{2,5,5,11}, 10)));
    }
}
