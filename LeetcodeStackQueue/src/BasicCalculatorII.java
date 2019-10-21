import java.util.Stack;

/**
 * Created by 79300 on 2019/10/20.
 */
public class BasicCalculatorII {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < charArray.length; i++) {
            //跳过空格
            if (charArray[i] == ' ') {
                continue;
            }
            //收集数字
            if (Character.isDigit(charArray[i])) {
                num = num * 10 + (charArray[i] - '0');

            } else {
                //这里是sign的情况
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(num * stack.pop());
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                //刷新当前的sign
                sign = charArray[i];
                //清空num
                num = 0;
            }
        }
        //加上最后一个num
        if (sign == '+') {
            stack.push(num);
        } else if (sign == '-') {
            stack.push(-num);
        } else if (sign == '*') {
            stack.push(num * stack.pop());
        } else if (sign == '/') {
            stack.push(stack.pop() / num);
        }
        int result = 0;
        for (int number : stack) {
            result = result + number;
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII bc = new BasicCalculatorII();
        System.out.println(bc.calculate(" 3/2 "));
    }
}
