import java.util.List;

/**
 * Created by 79300 on 2019/10/17.
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.size() == 0) return 0;
        return helper(nestedList, 1);
    }

    private int helper(List<NestedInteger> nestedList, int depth) {
        int result = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                result += ni.getInteger() * depth;
            } else {
                result += helper(ni.getList(),depth+1);
            }
        }
        return result;
    }
}
