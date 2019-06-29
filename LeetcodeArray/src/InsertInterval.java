import java.util.LinkedList;

/**
 * Created by 79300 on 2019/6/29.
 * 如果两个集合相交，它们最大的开始端一定小于或等于最小的结束端。
 */
public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        LinkedList<int[]> result = new LinkedList<>();
        if (intervals.length == 0) {
            result.add(newInterval);
            return result.toArray(new int[result.size()][2]);
        }
        //在newInterval之前的直接加到结果里
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        //直接把newInterval丢下来
        result.add(newInterval);
        while (i < intervals.length) {
            //有重合就Merge
            if (overlap(intervals[i], newInterval)) {
                int[] temp_interval = result.removeLast();
                temp_interval[0] = Math.min(temp_interval[0], intervals[i][0]);
                temp_interval[1] = Math.max(temp_interval[1], intervals[i][1]);
                result.add(temp_interval);
                //没重合就直接加到结果里
            } else if (intervals[i][0] > newInterval[1]) {
                result.add(intervals[i]);
            }
            i++;
        }
        return result.toArray(new int[result.size()][2]);
    }

    private boolean overlap(int[] interval1, int[] interval2) {
        //如果两个集合相交，最大的开始端一定小于或等于最小的结束端。
        return Math.max(interval1[0], interval2[0]) <= Math.min(interval1[1], interval2[1]);
    }

    public static void main(String[] args) {
        InsertInterval ii = new InsertInterval();
        int[][] a = ii.insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}
