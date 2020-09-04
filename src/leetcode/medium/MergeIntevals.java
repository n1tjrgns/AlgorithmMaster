package medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

/*Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.



Constraints:

intervals[i][0] <= intervals[i][1]*/
//배열을 합친다 -> 추가 및 삭제 -> 추가 및 삭제에 용이한 자료구조는 ? -> 연결리스트
public class MergeIntevals implements Comparator<int[]>{

    //배열 합치기
    //각각 하나씩 비교를 해야함 -> 재귀
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o1[0], o2[0]);
    }

    public int[][] merge(int[][] intervals) {
        //각 1차원 배열의 순서를 맞추기 위해 정렬
        Collections.sort(Arrays.asList(intervals), new MergeIntevals());
        System.out.println(Arrays.deepToString(intervals));

        LinkedList<int[]> merged = new LinkedList<>();

        for(int[] interval : intervals){
            //리스트가 비어있거나, 마지막 값보다 다음 첫번째값이 큰 경우 추가 merge되지 않으니깐 바로 추가하는것
            //                            3, 3, 8            <  1, 2, 4
            // 1
            if(merged.isEmpty() || merged.getLast()[1] < interval[0]){
                merged.add(interval);
            }else{
                //추가적으로 공간을 생성하지 않고 큰 숫자로 링크드리스트의 값을 변경해줌
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }

            System.out.println("merged.getLast()[0] : " + merged.getLast()[0]);
            System.out.println("merged.getLast()[1] : " + merged.getLast()[1]);
            System.out.println("interval[0] : " + interval[0]);
            System.out.println("interval[1] : " + interval[1]);

            System.out.println("merged.toArray(new int[merged.size()][] : " + Arrays.deepToString(merged.toArray(new int[merged.size()][])));
        }

        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        MergeIntevals m = new MergeIntevals();
        //System.out.println(m.merge(new int[][]{{1,3},{2,4},{6,8}}));
        System.out.println(m.merge(new int[][]{{1,3},{2,4}}));
    }


}
