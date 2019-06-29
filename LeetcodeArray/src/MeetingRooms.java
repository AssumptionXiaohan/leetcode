import java.util.Arrays;

/**
 * Created by 79300 on 2019/6/29.
 * 和MergeIntervals非常类似!!见MergeInterval解答
 * 先sort一遍，然后判断有没有重叠
 */
public class MeetingRooms {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals,(int[] i1,int[] i2)->Integer.compare(i1[0],i2[0]));
        for(int i=1;i<intervals.length;i++){
            if(overlap(intervals[i],intervals[i-1])) return false;
        }
        return true;
    }
    private boolean overlap(int[] interval1, int[] interval2) {
        //如果两个集合相交，最大的开始端一定小于或等于最小的结束端。
        return Math.max(interval1[0], interval2[0]) < Math.min(interval1[1], interval2[1]);
    }
}
