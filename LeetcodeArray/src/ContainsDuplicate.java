import java.util.HashSet;
import java.util.Set;

/**
 * Created by 79300 on 2019/6/26.
 * 这题用hashset就可以不需要用hashmap
 * 因为没有需要映射到的value
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
        }
        return false;
    }
}
