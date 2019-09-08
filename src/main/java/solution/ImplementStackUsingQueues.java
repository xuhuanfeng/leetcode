package solution;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.Assert.*;

/**
 * @author huanfeng.xu
 * @date 2019-09-07 15:22
 * @see <a href="https://leetcode.com/problems/implement-stack-using-queues/">225. Implement Stack using Queues</a>
 */
public class ImplementStackUsingQueues {
    @Test
    public void test01() {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        assertEquals(2, myStack.top());
        assertEquals(2, myStack.pop());
        myStack.push(10);
        myStack.push(20);
        assertEquals(20, myStack.top());
        myStack.pop();
        myStack.pop();
        assertFalse(myStack.empty());
        myStack.pop();
        assertTrue(myStack.empty());
    }
}

class MyStack {

    private Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue.isEmpty()) {
            queue.offer(x);
        } else {
            queue.offer(x);
            int size = queue.size();
            int cnt = 1;
            while (cnt < size) {
                queue.offer(queue.poll());
                cnt++;
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}