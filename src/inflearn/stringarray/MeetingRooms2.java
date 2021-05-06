package inflearn.stringarray;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRooms2 {
    public static class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e){
            start = s;
            end = e;
        }
    }

    public int countMeetingRooms(Interval[] intervals){

        //시작시간으로 정렬
        Arrays.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        //end 시간에 대한 오름차순으로 정렬
        //오름차순으로 정렬함으로써 앞에서부터 비교해나갈 수 있음
        Queue<Interval> queue = new PriorityQueue<>((a, b) -> a.end - b.end);

        queue.add(intervals[0]);
        System.out.println("queue = " + queue.peek().end);

        for(int i=1; i<intervals.length; i++){
            System.out.println("start = " + queue.peek().start + " :: end = " + queue.peek().end);
            System.out.println(intervals[i].start);
            if (queue.peek().end <= intervals[i].start){
                queue.poll();
            }

            queue.add(intervals[i]);
        }

        return queue.size();
    }

    public static void main(String[] args) {
        MeetingRooms2 meetingRooms = new MeetingRooms2();
        System.out.println(meetingRooms.countMeetingRooms(new MeetingRooms2.Interval[]{new MeetingRooms2.Interval(0, 30), new MeetingRooms2.Interval(4,9),new MeetingRooms2.Interval(5,15),new MeetingRooms2.Interval(10, 16)}));
    }
}
