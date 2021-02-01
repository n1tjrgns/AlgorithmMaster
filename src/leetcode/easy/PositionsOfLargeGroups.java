package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/positions-of-large-groups/
 * In a string s of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
 *
 * A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, "xxxx" has the interval [3,6].
 *
 * A group is considered large if it has 3 or more characters.
 *
 * Return the intervals of every large group sorted in increasing order by start index.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the only large group with start index 3 and end index 6.
 */
public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> largeGroup = new ArrayList<>();
        int count=1;
        //abbxxxxzzy
        for(int i=0; i<s.length()-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                count++;
            }else{
                if (count >=3){
                    List<Integer> list = new ArrayList<>();
                    list.add(i-count+1);
                    list.add(i);
                    largeGroup.add(list);
                }
                count=1;
            }
        }
        //aaa -> 같은거 3개인 경우에는 else를 안탐
        if (count >= 3){
            List<Integer> list = new ArrayList<>();
            list.add(s.length()-1-count+1); //그 경우에는 전체 길이에서 빼줘야함
            list.add(s.length()-1);
            largeGroup.add(list);
        }
        return largeGroup;
    }
    public static void main(String[] args) {
        PositionsOfLargeGroups p = new PositionsOfLargeGroups();
        //System.out.println(p.largeGroupPositions("abbxxxxzzy"));
        System.out.println(p.largeGroupPositions("aaa"));
    }
}
