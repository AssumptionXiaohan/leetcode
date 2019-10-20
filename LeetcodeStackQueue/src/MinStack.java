import java.util.Stack;

/**
 * Created by 79300 on 2019/10/20.
 * 用一个stack来存minvalue,与valStack同步push和pop
 */
public class MinStack {
    Stack<Integer> valStack;
    Stack<Integer> minStack;

    public MinStack() {
        valStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        valStack.push(x);
        if(minStack.isEmpty()){
            minStack.push(x);
        } else if (x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        valStack.pop();
        minStack.pop();
    }

    public int top() {
        return valStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
