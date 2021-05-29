package inflearn.stringarray.sec2;

import java.util.Arrays;
import java.util.Collections;

/*
* 정수 배열 번호와 정수 k가 지정된 경우 배열에서 k번째 가장 큰 요소를 반환합니다.

이 요소는 정렬된 순서대로 k번째 가장 큰 요소이지 k번째 고유 요소가 아닙니다.
높임말높임말 번역 설정타겟 TTS복사하기번역 저장번역 저장
* */
public class KthLargestElementInanArray {
    // 배열에서 k 번째로 큰 수 리턴하기
    // 내림차순해서 k 번째 있는 수만 리턴하면 될것같은데,,, 이게 미듐?
    public int findKthLargest(int[] nums, int k) {
        //내림차순으로 정렬 후 리턴
        Integer[] castNums = Arrays.stream(nums).boxed().toArray(Integer[]::new);

        Arrays.sort(castNums, Collections.reverseOrder());

        System.out.println("castNums = " + Arrays.toString(castNums));
        return castNums[k-1];

        //오름차순으로 정렬 후 바로 리턴
        /*int n = nums.length;
        Arrays.sort(nums);
        return nums[n-k];*/

    }

    public static void main(String[] args) {
        KthLargestElementInanArray k = new KthLargestElementInanArray();
        System.out.println(k.findKthLargest(new int[]{3,2,1,5,6,4}, 2));
        System.out.println(k.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4));
    }
}
