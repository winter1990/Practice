package practice.leetcode.ez;

import java.util.Stack;

/**
 * @design
 *
 * clarify the operations we need to implement:
 * get/poll - integer
 * get/peek - integer
 * put/push - int
 * is empty - boolean
 *
 * then think about the basic rules of queue - FIFO (ordered) and we cannot access to the element in the middle
 * so for index based data structure, we can skip
 *
 * stack is the complete reverse order compared to queue
 * q1 is for put
 * q2 is for get
 *
 */
public class ImplementQueueUsingStacks {
}

class MyQueue {
    /** Initialize your data structure here. */
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return stack2.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
