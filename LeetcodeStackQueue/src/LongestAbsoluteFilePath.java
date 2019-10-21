import java.util.Stack;

/**
 * Created by 79300 on 2019/10/20.
 */
public class LongestAbsoluteFilePath {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLength = 0;
        for (String str : input.split("\n")) {
            //lastIndexOf return -1如果没有找到\t
            int numOfT = str.lastIndexOf("\t") + 1;
            int level = numOfT + 1;
            //先把之前的路径pop出来
            while (stack.size() > level) {
                stack.pop();
            }
            //计算length把当前的push进去,length需要减掉\t的个数，加上1代表"/"
            int length = str.length() - numOfT + 1 + stack.peek();
            stack.push(length);
            if (str.contains(".")) maxLength = Math.max(maxLength, stack.peek() - 1);
        }
        return maxLength;
    }
}
