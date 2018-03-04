package practice.leetcode.ez;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack2 {

    Queue<Integer> q;

    public MyStack2() {
        q = new LinkedList<Integer>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        q.add(x);
        for (int i = 1; i < q.size(); i++) {
            q.add(q.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();
    }

    /** Get the top element. */
    public int top() {
        return q.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q.isEmpty();
    }
}
