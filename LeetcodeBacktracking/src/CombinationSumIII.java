import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/25.
 */
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        if (k > 9 || k <= 0 || n <= 0) return result;
        helper(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> current, int k, int target, int num) {
        if (k < 0) return;
        if (target < 0) return;
        if (target == 0 && k == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = num; i <= 9; i++) {
            if (i <= target) {
                current.add(i);
                helper(result, current, k - 1, target - i, i + 1);
                current.remove(current.size() - 1);
            }
        }
    }
}
