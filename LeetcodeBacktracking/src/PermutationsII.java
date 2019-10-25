import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 79300 on 2019/10/25.
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        helper(result,new ArrayList<>(),visited,nums);

        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> current, boolean[] visited, int[] nums){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        //保证是一个数组里没有的数字
        int pre = nums[0]-1;
        for(int i=0;i<nums.length;i++){
            if(!visited[i]&&nums[i]!=pre){
                pre = nums[i];
                current.add(nums[i]);
                visited[i] = true;
                helper(result,current,visited,nums);
                //backtracking
                visited[i] = false;
                current.remove(current.size()-1);
            }
        }
    }
}
