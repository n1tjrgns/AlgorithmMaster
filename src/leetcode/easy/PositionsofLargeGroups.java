package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * In a string s of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like s = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z", and "yy".
 *
 * A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group.
 * In the above example, "xxxx" has the interval [3,6].
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
 * Example 2:
 *
 * Input: s = "abc"
 * Output: []
 * Explanation: We have groups "a", "b", and "c", none of which are large groups.
 * Example 3:
 *
 * Input: s = "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * Explanation: The large groups are "ddd", "eeee", and "bbb".
 * Example 4:
 *
 * Input: s = "aba"
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s contains lower-case English letters only.
 */
public class PositionsofLargeGroups {
    //같은 문자가 3번 이상 반복되면 큰 그룹으로 분류한다.
    //큰 그룹에 해당할 때 해당 시작 인덱스와 끝 인덱스를 저장한다.
    public List<List<Integer>> largeGroupPositions(String s) {
        /**
         * 1.같은 문자가 몇번 나왔는지?
         * 2.해당 문자는 3번 이상 나왔는가? -> 3번이 안넘으면 카운트 할 필요 없음, 근데 문자열이 떨어져서 3번 나올 수도있는데
         * 3.해당 문자의 시작 인덱스, 끝 인덱스는?
         */


        List<List<Integer>> totalGroup = new ArrayList<>();

        //abbxxxxzzy -> [3,6]
        int cnt=1;
        for(int i=0; i<s.length()-1; i++){
            if (s.charAt(i) == s.charAt(i+1)){
                cnt++;
               // System.out.println("cnt = " + cnt);
            }else{
                if (cnt >= 3){
                    List<Integer> list = new ArrayList<>();
                   // System.out.println("i = " + i);
                    list.add(i-cnt+1);
                    list.add(i);
                    totalGroup.add(list);

                   // System.out.println("list = " + list);
                }
                cnt=1;
            }
        }

        //길이가 3인 경우
        if (cnt >= 3){
            List<Integer> list = new ArrayList<>();
            //3-
            list.add(s.length()-1-cnt+1);
            list.add(s.length()-1);
            totalGroup.add(list);

            //System.out.println("list = " + list);
        }


        return totalGroup;
    }

    public static void main(String[] args) {
        PositionsofLargeGroups p = new PositionsofLargeGroups();
        System.out.println(p.largeGroupPositions("abbxxxxzzy"));
        System.out.println(p.largeGroupPositions("aaa"));
    }
}
