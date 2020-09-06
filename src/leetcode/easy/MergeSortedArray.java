package leetcode.easy;

import java.util.Arrays;

public class MergeSortedArray {
    public int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1 = m - 1;
        int tail2 = n - 1;
        int total = m+n-1;

        while (tail1 >= 0 && tail2 >= 0) {
            nums1[total--] = (nums1[tail1] > nums2[tail2]) ? nums1[tail1--] : nums2[tail2--];
            System.out.println(Arrays.toString(nums1));
        }

        //tail2 의 요소가 전부 tail1 보다 작은 경우 tail2의 요소를 맨 앞에다 넣어준다.
        while( tail2 >= 0){
            nums1[total--] = nums2[tail2--];
            System.out.println("22: " + Arrays.toString(nums1));
        }


        return nums1;
    }
    public static void main(String[] args) {
        MergeSortedArray t = new MergeSortedArray();
        System.out.println(Arrays.toString(t.merge(new int[]{1,2,3,0,0,0}, 3, new int[]{0,0,0}, 3)));
    }

}
