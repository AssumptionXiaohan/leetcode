/**
 * Created by 79300 on 2019/6/24.
 */
public class HIndex {
    public int hIndex(int[] citations) {
        // 也是用一个额外的数组来保存数字出现的次数
        // 但因为返回的值最多不超过citations.length,所以额外的数组index到citations.length就可以了
        int count[] = new int[citations.length + 1];
        for (int i = 0; i < citations.length; i++) {
            //把count数组的index作为对应的引用量，开始统计数量
            if (citations[i] < citations.length) {
                count[citations[i]]++;
            } else {
                //超过citations.length的直接加在最后一位
                count[citations.length]++;
            }
        }
        int total = 0;
        for (int j = count.length - 1; j >= 0; j--) {
            total = total + count[j];
            //这里的判断条件说明，大于等于j的引用量总和total已经有j个以上了，满足条件
            if (total >= j)
                return j;
        }
        return -1;
    }
}
