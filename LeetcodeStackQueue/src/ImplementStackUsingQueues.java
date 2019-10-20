import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by 79300 on 2019/10/20.
 * 正常的简单粗暴的办法..把queue里的东西放到第二个queue里，直到剩最后一个取出来..
 */
public class ImplementStackUsingQueues {
    Queue<Integer> pushQueue;
    Queue<Integer> popQueue;
    /** Initialize your data structure here. */
    public ImplementStackUsingQueues() {
        pushQueue = new LinkedList();
        popQueue = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        pushQueue.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(popQueue.isEmpty()){
            while (pushQueue.size()>1){
                popQueue.offer(pushQueue.poll());
            }
            Queue<Integer> temp = popQueue;
            popQueue = pushQueue;
            pushQueue = temp;
        }
        return popQueue.poll();
    }

    /** Get the top element. */
    public int top() {
        if(popQueue.isEmpty()){
            while (pushQueue.size()>1){
                popQueue.offer(pushQueue.poll());
            }
            Queue<Integer> temp = popQueue;
            popQueue = pushQueue;
            pushQueue = temp;
        }
        int temp = popQueue.peek();
        pushQueue.offer(popQueue.poll());
        return temp;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return popQueue.isEmpty()&&pushQueue.isEmpty();
    }
}
