package inflearn.stringarray.sec1;

import java.util.Arrays;
import java.util.LinkedList;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {

        //정렬
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));

        LinkedList<int[]> mergeList = new LinkedList<>();
        for (int[] interval : intervals) {
            if (mergeList.isEmpty() || mergeList.getLast()[1] < interval[0]){
                mergeList.add(interval);
            }else{
                mergeList.getLast()[1] = Math.max(mergeList.getLast()[1],interval[1]);
            }
        }

        return mergeList.toArray(new int[mergeList.size()][]);
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 3}, {2, 6},{8,10},{15,18}})));
        //System.out.println(Arrays.deepToString(mergeIntervals.merge(new int[][]{{1, 4}, {4, 5}})));
    }
}
