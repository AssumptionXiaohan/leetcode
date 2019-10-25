import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/25.
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null||nums.length==0){
            return result;
        }
        boolean[] visited = new boolean[nums.length];
        helper(result,new ArrayList<>(),visited,nums);
        return result;
    }

    private void helper(List<List<Integer>> result,List<Integer> current,boolean[] visited,int[] nums){
        if(current.size()==nums.length){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
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
