package inflearn.stringarray.sec1;

import java.util.Arrays;

//회의실 시간이라는 연속적인 배열이 주어질 때, 겹치는 시간이 있다면 false, 아니면 true 리턴
public class MeetingRooms {
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
    public boolean canAttendMeetings(Interval[] intervals){

        System.out.println("intervals = " + intervals.length);
        System.out.println("intervals = " + intervals[0].start);
        System.out.println("intervals = " + intervals[0].end);

        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];

        for(int i=0; i<intervals.length; i++){
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        System.out.println(Arrays.toString(starts));
        System.out.println(Arrays.toString(ends));

        //다음 시작값보다 크면 false
        for(int i=0; i<starts.length-1; i++){
            if (starts[i+1] < ends[i]){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        MeetingRooms meetingRooms = new MeetingRooms();
        System.out.println(meetingRooms.canAttendMeetings(new Interval[]{new Interval(0, 30), new Interval(5,10),new Interval(15,20)}));
    }
}
