package inflearn.stringarray.sec2StringArray2;

import java.util.ArrayList;
import java.util.List;

/*
* Given a sorted integer array nums, where the range of elements
* are in the inclusive range [lower, upper], return its missing ranges.
Example:
Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
Output: ["2", "4->49", "51->74", "76->99"]*/
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> answer = new ArrayList<>();
        int next = lower;
        for(int i=0; i<nums.length; i++){
            if (nums[i] < next) continue;
            if (nums[i] == next){
                next++;
                continue;
            }
            answer.add(transString(next, nums[i]-1));
            next = nums[i]+1;
        }
        if (next <=upper){
            answer.add(transString(next,upper));
        }
        return answer;
    }

    private String transString(int next, int i) {
        return next == i ? String.valueOf(next) : String.format("%d->%d", next,i);
    }


    public static void main(String[] args) {
        MissingRanges m = new MissingRanges();
        System.out.println(m.findMissingRanges(new int[]{0,1,3,50,75},0,99));
    }
}
