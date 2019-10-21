import java.util.Stack;

/**
 * Created by 79300 on 2019/10/20.
 */
public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char[] charArray = s.toCharArray();
        int i = 0, sign = 1, result = 0;
        while (i < charArray.length) {
            //跳过空格
            if (charArray[i] == ' ') {
                i++;
                continue;
                //数字加到result里
            } else if (Character.isDigit(charArray[i])) {
                int num = 0;
                while (i < charArray.length && Character.isDigit(charArray[i])) {
                    num = num * 10 + (charArray[i] - '0');
                    i++;
                }
                //计算当前的result
                result = result + sign * num;
                //出现左括号的时候把result存在stack里,再把sign存在stack里
            } else if (charArray[i] == '(') {
                stack.push(result);
                stack.push(sign);
                //把result重置为0，sign重置为1开始计算括号里的内容
                result = 0;
                sign = 1;
                i++;
                //操作符入栈
            } else if (charArray[i] == '+') {
                sign = 1;
                i++;
            } else if (charArray[i] == '-') {
                sign = -1;
                i++;
                //当前是')'的情况
            } else {
                //result的值是现在括号里计算的值
                //stack的顶部是括号里内容的sign,下一个顶部是之前的result
                result = stack.pop() * result + stack.pop();
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculator bc = new BasicCalculator();
        System.out.println(bc.calculate("1 + 1"));
    }
}
