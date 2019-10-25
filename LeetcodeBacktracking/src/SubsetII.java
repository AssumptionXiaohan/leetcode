import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 79300 on 2019/10/24.
 */
public class SubsetII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length ==0) return result;
        List<Integer> current = new ArrayList<>();
        Arrays.sort(nums);
        helper(result,current,0,nums,true);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> current,int idx, int[] nums,boolean isTaken){
        if(idx==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        helper(result,current,idx+1,nums,false);
        if(idx==0||nums[idx-1]!=nums[idx]||isTaken){
            current.add(nums[idx]);
            helper(result,current,idx+1,nums,true);
            current.remove(current.size()-1);
        }
    }

}
