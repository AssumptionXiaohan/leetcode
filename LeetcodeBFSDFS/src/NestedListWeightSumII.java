import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 79300 on 2019/10/17.
 * Input: [[1,1],2,[1,1]]
 * Output: 8
 * Explanation: Four 1's at depth 1, one 2 at depth 2.
 * <p>
 * 本来是2*2+4*1 = 8
 * 可以理解成2*1+(2+1+1+1+1)*1,每次进入更深一层的时候多加一个2
 */
public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        if (nestedList == null || nestedList.isEmpty()) return 0;
        int result = 0, unweightedSum = 0;
        while (!nestedList.isEmpty()) {
            List<NestedInteger> nextList = new ArrayList<>();
            for (NestedInteger ni : nestedList) {
                if (ni.isInteger()) {
                    unweightedSum += ni.getInteger();
                } else {
                    nextList.addAll(ni.getList());
                }
            }
            result = result + unweightedSum;
            nestedList = nextList;
        }
        return result;
    }
}
