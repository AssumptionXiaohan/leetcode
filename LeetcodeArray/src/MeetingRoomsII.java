import java.util.Arrays;

/**
 * Created by 79300 on 2019/6/29.
 * 这题和MeetingRoomsI不太一样的是，不能只靠sort第一个元素
 * 因为会议的话start和end的时间节点都很重要
 */
public class MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length <= 1) return intervals.length;
        //把每一段会议的开始时间和结束时间分开存在两个数组里并排序
        int[] start_times = new int[intervals.length];
        int[] end_times = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start_times[i] = intervals[i][0];
            end_times[i] = intervals[i][1];
        }
        Arrays.sort(start_times);
        Arrays.sort(end_times);
        //双指针法，当一个会议的start比另一个end大的时候说明不需要多一个房间
        int start = 0, end = 0, min_room = 0;
        for(;start<start_times.length;start++) {
            if (start_times[start] < end_times[end]) {
                min_room++;
            } else {
                end++;
            }
        }
        return min_room;
    }


    public static void main(String[] args) {
        MeetingRoomsII mr = new MeetingRoomsII();
        System.out.println(mr.minMeetingRooms(new int[][]{{13, 15}, {1, 13}, {6, 9}}));
    }
}
