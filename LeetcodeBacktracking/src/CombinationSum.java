import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/25.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        List<List<Integer>> result = new ArrayList<>();
        if(candidates==null||candidates.length==0) return result;
        List<Integer> current = new ArrayList<>();
        helper(result,current,target,candidates,0);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> current, int target, int[] nums, int idx){
        if(target==0){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(nums[i]<=target){
                current.add(nums[i]);
                helper(result,current,target-nums[i],nums,i);
                current.remove(current.size()-1);
            }
        }
    }

}
