import java.util.Stack;

/**
 * Created by 79300 on 2019/9/6.
 * https://www.youtube.com/watch?v=M1Vw5Tk1rw4
 */
public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() <= 1) return 0;
        int leftMost = -1, max = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);
            if (current_char == '(') stack.push(i);
            if (current_char == ')') {
                //如果stack非空，把之前的左括号pop出来，更新max的值
                if(!stack.empty()){
                    stack.pop();
                    //如果stack非空，用当前的idx减去栈顶的值，否则减去leftMost的值
                    max = stack.empty()?Math.max(max,i-leftMost):Math.max(max,i-stack.peek());
                }else {
                    //如果stack是空的，更新leftMost的值
                    leftMost = i;
                }
            }
        }
        return max;
    }
}
