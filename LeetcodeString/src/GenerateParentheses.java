import java.util.ArrayList;
import java.util.List;

/**
 * Created by 79300 on 2019/9/5.
 * https://www.youtube.com/watch?v=PCb1Ca_j6OU
 * 左括号可以随时添加到string里，右括号需要左边有多余的左括号的时候才可以加上
 *
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> lst = new ArrayList<>();
        helper("",n,0,0,lst);
        return lst;
    }

    private void helper(String currentString, int n, int left, int right,List<String> lst){
        if(right==n){
            lst.add(currentString);
            return;
        }
        if(left<n){
            helper(currentString+"(",n,left+1,right,lst);
        }
        if(right<left){
            helper(currentString+")",n,left,right+1,lst);
        }
    }
}
