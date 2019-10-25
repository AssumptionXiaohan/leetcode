import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/24.
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if(n<=0||k<=0||n<k) return result;
        List<Integer> current = new ArrayList<>();
        helper(result,current,1,n,k);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> current, int num,int n,int k){
        if(current.size()==k){
            result.add(new ArrayList<>(current));
            return;
        }
        if(num==n+1) return;
        //Don’t choose num
        helper(result,current,num+1,n,k);
        //Choose num
        current.add(num);
        helper(result,current,num+1,n,k);
        //backtracking
        current.remove(current.size()-1);
    }
}
