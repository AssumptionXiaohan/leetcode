import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/24.
 */
public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> current = new ArrayList<>();
        helper(current, result, nums, 0);
        return result;
    }

    private void helper(List<Integer> current, List<List<Integer>> result, int[] nums, int idx) {
        result.add(new ArrayList<>(current));
        for (int i = idx; i < nums.length; i++) {
            current.add(nums[i]);
            helper(current, result, nums, i + 1);
            //backtracking
            current.remove(current.size() - 1);
        }
    }

}
