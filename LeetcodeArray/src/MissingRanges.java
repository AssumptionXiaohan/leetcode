import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/7/1.
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(format(lower, upper));
            return result;
        }
        //最左边缺失的，由lower和nums[0]的差距产生
        if (nums[0] > lower) {
            result.add(format(lower, nums[0] - 1));
        }
        //中间缺失的
        for (int i = 0; i < nums.length; i++) {
            // 处理overflow 最小值的话-1就变成最大值了 所以需要跳过最小值..
            // i+1是最小值的话说明前边都是最小值了直接跳过就行
            while (i + 1 < nums.length && nums[i + 1] == Integer.MIN_VALUE) i++;
            //这里用>=不用==是为了避免[1,1,1]这种情况，也需要被跳过
            while (i + 1 < nums.length && nums[i] >= nums[i + 1] - 1) {
                i++;
            }
            if (i != nums.length - 1) result.add(format(nums[i] + 1, nums[i + 1] - 1));
        }

        //最后缺失的，由nums[length-1]和upper的差距产生
        if (nums[nums.length - 1] < upper) {
            result.add(format(nums[nums.length - 1] + 1, upper));
        }

        return result;
    }


    private String format(int i1, int i2) {
        return i1 == i2 ? String.valueOf(i1) : Integer.toString(i1) + "->" + Integer.toString(i2);
    }
}
