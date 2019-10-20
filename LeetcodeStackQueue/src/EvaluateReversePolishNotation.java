import java.util.Stack;

/**
 * Created by 79300 on 2019/10/20.
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        int num1=0,num2=0;
        Stack<String> stack = new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String current = tokens[i];
            if(current.equals("+")){
                num1 = Integer.valueOf(stack.pop());
                num2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(num1+num2));
            }else if(current.equals("-")){
                num1 = Integer.valueOf(stack.pop());
                num2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(num2-num1));
            }else if(current.equals("*")){
                num1 = Integer.valueOf(stack.pop());
                num2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(num1*num2));
            }else if(current.equals("/")){
                num1 = Integer.valueOf(stack.pop());
                num2 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(num2/num1));
            }else {
                stack.push(current);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
