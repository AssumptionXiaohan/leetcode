import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by 79300 on 2019/6/29.
 * 先按第一个元素把区间都排序
 * 然后顺着merge一遍
 * O(NlogN)
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        //先排序
        Arrays.sort(intervals, (int[] i1, int[] i2) -> Integer.compare(i1[0], i2[0]));
        LinkedList<int[]> result = new LinkedList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] temp_interval = result.removeLast();
            //假设有重叠的话，更新这个区间重新添加
            if(overlap(intervals[i],temp_interval)){
                temp_interval[0] = Math.min(temp_interval[0],intervals[i][0]);
                temp_interval[1] = Math.max(temp_interval[1],intervals[i][1]);
                result.add(temp_interval);
            }else {
                //没有重叠，把区间添加回去，再把现在的作为新的区间添加
                result.add(temp_interval);
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }

    private boolean overlap(int[] interval1, int[] interval2) {
        //如果两个集合相交，最大的开始端一定小于或等于最小的结束端。
        return Math.max(interval1[0], interval2[0]) <= Math.min(interval1[1], interval2[1]);
    }

    public static void main(String[] args) {
        MergeIntervals mi = new MergeIntervals();
        mi.merge(new int[][]{{1,4},{0,2},{3,5}});
    }
}
