import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/7/1.
 * 思路比较简单的一道题，但是下面的解法可以少用一个left指针
 */
public class SummaryRangesII {
    public List<String> summaryRanges(int[] nums) {

        List<String> result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(Integer.toString(nums[0]));
            return result;
        }

/*        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == left || nums[i] == nums[i - 1] + 1) continue;
            String s;
            if (left == i - 1) {
                s = Integer.toString(nums[left]);
                result.add(s);
                left++;
            } else {
                s = Integer.toString(nums[left]) + "->" + Integer.toString(nums[i - 1]);
                result.add(s);
                left = i;
            }
        }
        if (left == nums.length - 1) result.add(Integer.toString(nums[nums.length - 1]));
        else result.add(Integer.toString(nums[left]) + "->" + Integer.toString(nums[nums.length - 1]));*/
        for (int i = 0; i < nums.length; i++) {
            //相当于前面的left保存了左端的值
            int a = nums[i];
            //假设右边是连续的，i一直往右走
            while (i + 1 < nums.length && nums[i] == nums[i + 1] - 1) {
                i++;
            }
            //后面的元素与nums[i]不连接的情况
            if (nums[i] == a) {
                result.add(Integer.toString(a));
                //后面的元素有链接的情况，现在的i相当于right指针
            } else {
                result.add(Integer.toString(a) + "->" + Integer.toString(nums[i]));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        SummaryRangesII sr = new SummaryRangesII();
        System.out.println(sr.summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}).toString());
    }
}
