import java.util.TreeMap;

/**
 * Created by 79300 on 2019/6/29.
 * Treemap 数据结构 是一个有序的hashmap
 * 其中有两个方法：lowerKey是现在的map中比key小的最大的key
 * higherKey是现在的map中比key大的最小的key
 * 比如现在map里有0,2,4,9 插入的新key为7，那么lowerKey是4，higherKey是9
 * 我们用TreeMap<Integer,int[]>的结构，其中Integer代表区间的起始值
 */
public class SummaryRanges {
    TreeMap<Integer, int[]> treeMap;

    /**
     * Initialize your data structure here.
     */
    public SummaryRanges() {
        treeMap = new TreeMap<>();
    }


    public void addNum(int val) {
        if (treeMap.containsKey(val)) return;
        //0,2,4,9  7 (4,9)
        Integer left_key = treeMap.lowerKey(val);
        Integer right_key = treeMap.higherKey(val);
        //和左右两边都连在一起
        if (left_key != null && right_key != null && treeMap.get(left_key)[1] == val - 1 && right_key == val + 1) {
            treeMap.get(left_key)[1] = treeMap.get(right_key)[1];
            treeMap.remove(right_key);
            //只和左边连在一起或者被包括在左边
        } else if (left_key != null && treeMap.get(left_key)[1] >= val - 1) {
            treeMap.get(left_key)[1] = Math.max(val,treeMap.get(left_key)[1]);
            //只和右边连在一起(不可能被包括在右边
        } else if (right_key != null && right_key == val + 1) {
            int[] temp_array = treeMap.get(right_key);
            temp_array[0] = val;
            treeMap.put(val,temp_array);
            treeMap.remove(right_key);
            //左右都没连在一起
        } else {
            int[] new_array = new int[]{val,val};
            treeMap.put(val,new_array);
        }

    }

    public int[][] getIntervals() {
        return treeMap.values().toArray(new int[treeMap.size()][2]);
    }
}
