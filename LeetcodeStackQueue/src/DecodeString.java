import java.util.Stack;

/**
 * Created by 79300 on 2019/10/20.
 * 用两个stack一个记录字母和方括号一个记录数字
 */
public class DecodeString {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();

        char[] charArray = s.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            //如果是数字的话，把整个数字计算出来push到numStack
            if (Character.isDigit(charArray[i])) {
                int num = 0;
                while (i < charArray.length && Character.isDigit(charArray[i])) {
                    num = num * 10 + (charArray[i] - '0');
                    i++;
                }
                numStack.push(num);
                //如果是字母的话，把整串字母push到stack
            } else if (Character.isLetter(charArray[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < charArray.length && Character.isLetter(charArray[i])) {
                    sb.append(charArray[i]);
                    i++;
                }
                stack.push(sb.toString());
            }else if(charArray[i]=='['){
                stack.push("[");
                i++;
                //这里是charArray[i]==']'的情况
            }else {
                String result = "";
                //把括号里的结果加上
                while (stack.peek()!="["){
                    result = stack.pop()+result;
                }
                //把"["pop出来
                stack.pop();
                //把result重复num次
                int num = numStack.pop();
                StringBuilder sb = new StringBuilder();
                while (num>0){
                    sb.append(result);
                    num--;
                }
                //把结果push到栈里
                stack.push(sb.toString());
                i++;
            }
        }
        String result = "";
        while (!stack.isEmpty()){
            result = stack.pop()+result;
        }
        return result;
    }
}
