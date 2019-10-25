import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 79300 on 2019/10/25.
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;
        Arrays.sort(candidates);
        List<Integer> current = new ArrayList<>();
        helper(result, current, target, candidates, 0);
        return result;

    }

    private void helper(List<List<Integer>> result, List<Integer> current, int target, int[] nums, int idx) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            //去重
            if (nums[i] <= target && (i == 0 || nums[i] != nums[i - 1] || i == idx)) {
                current.add(nums[i]);
                helper(result, current, target - nums[i], nums, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
