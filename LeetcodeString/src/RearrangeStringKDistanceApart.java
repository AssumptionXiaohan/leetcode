/**
 * Created by 79300 on 2019/7/12.
 * 用一个count的数组和一个valid数组-count表示每个字母出现的次数，valid表示每个字母下一个valid的出现位置
 * 主要思路在如何找到下一个被放进数组的元素应该是什么，找最优的元素：
 * 条件有3个：1.现在的index是可以被放进去的，是valid[i]之后的位置,
 * 2.这个元素要是所有valid元素中count最多的元素--这个是最重要的!!!!
 * 3.这个元素是没有被放完的，也就是count[i]>0
 */
public class RearrangeStringKDistanceApart {
    public String rearrangeString(String s, int k) {
        //先构建count和valid两个数组
        int[] count = new int[26];
        int[] valid = new int[26];
        //把26个字母计数一遍
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        //开始寻找最优位置并加入结果
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int nextChar = nextChar(count, valid, i);
            //能够找到最优解，修改count数组和valid数组，count--，valid找到下一个可放的位置
            //把当前的最优元素加到result里
            if (nextChar != -1) {
                count[nextChar]--;
                valid[nextChar] = i + k;
                result.append((char) (nextChar + 'a'));
                //找不到可以放的元素了说明无法按要求排列，返回空字符串
            }else {
                return "";
            }
        }
        return result.toString();
    }

    private int nextChar(int[] count, int[] valid, int index) {
        int max_count = Integer.MIN_VALUE;
        int next_position = -1;
        for (int i = 0; i < count.length; i++) {
            //count[i]>0和valid[i]<=index是为了保证i这个元素还有，并且可以放在现在的index的位置
            //count[i]>max_count是为了能找到目前符合要求的元素里剩余最多的一个元素放入
            if (count[i] > 0 && valid[i] <= index && count[i] > max_count) {
                max_count = count[i];
                next_position = i;
            }
        }
        //假设next_position是-1说明找不到下一个可以放置的元素了
        return next_position;
    }
}
