import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by 79300 on 2019/6/30.
 * 用最大堆和最小堆，两个一起。最小堆里存放较大的数字，最大堆里存放较小的数字
 * 保证最小堆的数量永远和最大堆的数量相等或者=最大堆的数量+1
 * 相等的时候平均取中位数，后面一中情况的中位数直接在最小堆里。
 */
public class MedianFinder {
    Queue<Integer> max;
    Queue<Integer> min;


    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        //最小堆，右边较大数字的最小值在堆顶
        max = new PriorityQueue<>();
        //最大堆，左边较小数字的最大值在堆顶
        min = new PriorityQueue<>(Comparator.reverseOrder());
    }

    public void addNum(int num) {
        //每次加一个数进来先到max里
        max.offer(num);
        //平衡一下它们的长度，避免max过长。
        //因为加入了一个元素，先把这个元素丢到min里保证max不会比min多出2个元素（这个时候最多多出两个元素，就是上一次添加之后max比min多一个元素的情况）
        //假设这个时候max比min元素少了（最多也只会少一个，就是上一次添加的时候两个堆元素相等），就倒回去一个
        min.offer(max.poll());
        if (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    public double findMedian() {
        //双数就返回平均值，奇数就返回中间的一个
        if ((max.size() + min.size()) % 2 == 0) return (max.element() + min.element()) / 2.0;
        else return (double) max.element();
    }
}
