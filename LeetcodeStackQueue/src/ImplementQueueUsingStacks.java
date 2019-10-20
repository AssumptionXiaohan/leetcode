import java.util.Stack;

/**
 * Created by 79300 on 2019/10/20.
 * 用一个stack用来push 一个stack用来pop
 * 每次popStack为空的时候就把pushStack里的东西全部倒过去
 */
public class ImplementQueueUsingStacks {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;

    public ImplementQueueUsingStacks() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        pushStack.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                int temp = pushStack.pop();
                popStack.push(temp);
            }
        }
        return popStack.pop();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if(popStack.isEmpty()){
            while (!pushStack.isEmpty()){
                int temp = pushStack.pop();
                popStack.push(temp);
            }
        }
        return popStack.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
