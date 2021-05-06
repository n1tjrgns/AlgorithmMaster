package inflearn.stringarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms2Array {
    public int minMeetingRooms(int[][] intervals) {
        //정렬
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[0]));
        List<Integer> ends = new ArrayList<>();
        //비교
        for (int i = 0; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];

            int targetIndex = -1;
            for (int j = 0; j < ends.size(); j++) {
                if (start >= ends.get(j)) {
                    targetIndex = j;
                    System.out.println("targetIndex = " + targetIndex);
                    break;
                }
            }

            if (targetIndex != -1) {
                System.out.println("settargetIndex = " + targetIndex);
                ends.set(targetIndex, end);
            } else {
                ends.add(end);
            }

            System.out.println("end = " + ends);
        }
        return ends.size();
    }

    public static void main(String[] args) {
        MeetingRooms2Array m = new MeetingRooms2Array();
        System.out.println(m.minMeetingRooms(new int[][]{{0,30},{4,9},{10,16},{5,15}}));
    }

}
