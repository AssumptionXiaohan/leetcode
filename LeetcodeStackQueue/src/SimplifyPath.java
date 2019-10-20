import java.util.Stack;

/**
 * Created by 79300 on 2019/10/20.
 * split("/")
 * 如果是".."就pop出栈顶元素
 * 如果不是"."或者".."或者""就说明是一个有效的文件夹名字 push进栈
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        for (String str : path.split("/")) {
            if (str.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else if (!str.equals(".") && !str.equals("")) {
                stack.push(str);
            }
        }
        if (stack.isEmpty()) return "/";
        String result = "";
/*
        while (!stack.isEmpty()) {
            result = stack.pop() + "/" + result;
        }
        return "/" + result.substring(0, result.length() - 1);
        */
        while (!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result;
    }

}
