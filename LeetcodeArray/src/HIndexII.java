/**
 * Created by 79300 on 2019/6/25.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        int low = 0, high = citations.length - 1, mid = (low + high) / 2;
        while (low <= high) {
            mid = (low + high) / 2;
            if (citations[mid] < citations.length - mid) {
                low = mid + 1;
            } else if (citations[mid] > citations.length - mid) {
                high = mid - 1;
            } else {
                return citations[mid];
            }
        }
        //考虑最后的return条件，也就是说二分查找之后没有找到准确值，这个时候说明要找的h不在数组里
        //如果这个时候mid<citations.length-mid，也就是说mid的值小于右边的元素个数，应该直接返回mid右边的元素个数
        //e.g. [1,4,7,9] 最后的mid在1这里，1<3，所以返回1右边的元素个数，也就是3个
        if (citations[mid] < citations.length - mid) {
            return citations.length - (mid + 1);
        } else {
            // else的情况就是mid>citations.length-mid了，也就是说mid的值大于右边的元素个数
            // 这个时候应该返回mid右边的元素个数加1，也就是算上了mid本身这个元素
            // e.g.[0,3,7,9,12,15,17] 最后的mid在7这里,7>5
            // 也就是说要返回包括7在内的右边的元素个数，也就是7、9、12、16、17一共5个
            return citations.length - mid;
        }
    }

}
