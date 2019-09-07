import java.util.Stack;

/**
 * Created by 79300 on 2019/9/3.
 * 用基础栈就可以
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() == 0) return true;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current_char = s.charAt(i);
            if (stack.size() == 0) stack.push(current_char);
            else {
                if (stack.peek() == '(' && current_char == ')' || (stack.peek() == '[' && current_char == ']') || (stack.peek() == '{') && current_char == '}') {
                    stack.pop();
                }else {
                    stack.push(current_char);
                }
            }
        }
        return stack.empty();
    }
}
