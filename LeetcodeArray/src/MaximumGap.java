import java.util.Arrays;

/**
 * Created by 79300 on 2019/6/28.
 * 思路：bucket sort
 * 把数组中的min-max的范围内，等距的建一些bucket放入合适的元素。
 * 比如数组内的数据是0-49，以10为间距可以建立5个bucket：0-9、10-19..40-49
 * <p>
 * 这题要求linear time，所以我们需要只在bucket之间相互比较，避免同一个bucket内部的比较
 * 所以我们要把间距gap设置为可能存在的最小的gap，也就是(max-min)/(length-1) P.S.把所有的gap平均了的时候最小
 * <p>
 * [1,3,7,9,10,12] 11/5 = 2.2
 * 假设gap为2，[1,3,5,7,9,11],可以看到从1开始即使每次都+2最后也只能到11，到不了12的
 * 所以说假设我们有一个最大最小值差11的长度为5的整数数组，我们的有序序列里的max gap最少应该是3(比3大的很容易找)
 * 所以这里我们取上界就可以
 * <p>
 * [1,4),[4,6),[7,9),[10,12),[12,15) 我们用length-1个区间就可以装下所有的数，也就是需要length-1个bucket
 * [min+k*gap,min+(k+1)*gap)
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) return 0;
        int max = nums[0], min = nums[0];
        //找出最大值最小值
        for (int number : nums) {
            max = Math.max(max, number);
            min = Math.min(min, number);
        }
        //最大值等于最小值的时候直接返回0,不然gap计算会变成0
        if (max == min) return 0;
        //计算最小gap
        int gap = (int) Math.ceil((double) (max - min) / (nums.length - 1));
        //建立n个bucket作为n个区间，因为max在最后计算的时候可能被丢到最后一个区间
        int[] bucket_min = new int[nums.length];
        int[] bucket_max = new int[nums.length];
        Arrays.fill(bucket_max, Integer.MIN_VALUE);
        Arrays.fill(bucket_min, Integer.MAX_VALUE);
        //把所有元素划分到对应的bucket
        for (int i = 0; i < nums.length; i++) {
            int index = (nums[i] - min) / gap;
            bucket_max[index] = Math.max(bucket_max[index], nums[i]);
            bucket_min[index] = Math.min(bucket_min[index], nums[i]);
        }
        //找到最大值。
        int max_gap = Integer.MIN_VALUE, pre_max = min;
        for (int j = 0; j < bucket_max.length; j++) {
            //这里一定要跳过空的bucket 要是bucket_min不是空的，那bucket_max肯定也不是空的所以不需要判断2次~
            if (bucket_min[j] != Integer.MAX_VALUE) {
                //j=0的时候因为pre_max=min了，其实这句话没有更新max_gap的值，应该到第二个篮子才开始更新
                max_gap = Math.max(max_gap, bucket_min[j] - pre_max);
                //j=0的时候主要操作是存下第一个篮子的最大值
                pre_max = bucket_max[j];
            }
        }
        return max_gap;
    }

    public static void main(String[] args) {
        MaximumGap mg = new MaximumGap();
        System.out.println(mg.maximumGap(new int[]{1, 999999}));
    }
}
