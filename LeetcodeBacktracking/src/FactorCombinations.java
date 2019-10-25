import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/25.
 */
public class FactorCombinations {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        if(n<=1) return result;
        helper(result,new ArrayList<>(),n,2);
        return result;
    }

    private void helper(List<List<Integer>> result,List<Integer> current,int target,int start){
        if(target==1){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=start;i<=target;i++){
            if(target%i==0&&current.size()!=1){
                current.add(i);
                helper(result,current,target/i,i);
                //backtracking
                current.remove(current.size()-1);
            }
        }
    }

}
