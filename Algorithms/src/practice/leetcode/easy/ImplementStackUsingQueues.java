package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @design method need to implement: push, pop, top, empty
 * [. . . .], push 1 [. . . 1], push 2 [. . 2 1] [. . 1 2], push 3 [. 3 1 2] [. 1 2 3]
 * poll directly poll from the queue [. . 1 2], peek return head element, empty check whether queue is empty
 */
public class ImplementStackUsingQueues {
}

class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (q1.isEmpty()) {
            q1.offer(x);
            while (!q2.isEmpty()) {
                q1.offer(q2.poll());
            }
        } else {
            q2.offer(x);
            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (!q1.isEmpty()) {
            return q1.poll();
        } else {
            return q2.poll();
        }
    }

    /**
     * Get the top element.
     */
    public int top() {
        return q1.isEmpty() ? q2.peek() : q1.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

class MyStack2 {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack2() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        if (!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
    }

    public void pop() {
        if (q1.isEmpty()) {
            int size = q2.size();
            for (int i = 1; i < size; i++) {
                q1.add(q2.poll());
            }
            q2.poll();
        } else {
            int size = q1.size();
            for (int i = 1; i < size; i++) {
                q2.add(q1.poll());
            }
            q1.poll();
        }
    }

    public int top() {
        int res;
        if (q1.isEmpty()) {
            int size = q2.size();
            for (int i = 1; i < size; i++) {
                q1.add(q2.poll());
            }
            res = q2.poll();
            q1.add(res);
        } else {
            int size = q1.size();
            for (int i = 1; i < size; i++) {
                q2.add(q1.poll());
            }
            res = q1.poll();
            q2.add(res);
        }
        return res;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}

class MyStack3 {
    private Queue<Integer> q = new LinkedList<Integer>();

    public void push(int x) {
        q.add(x);
        for (int i = 1; i < q.size(); i++) {
            q.add(q.poll());
        }
    }

    public void pop() {
        q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}