package practice.leetcode.ez;

import java.util.Stack;

/**
 * @design
 * @stack
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time
 *
 * method 1
 * using two stacks, one is sfor normal store and retrieve, one is to store the minimum valus
 * push: if empty, just push, otherwise if value <= min.peek, push
 * pop: if the value popped from normal stack = min stack peek value, then pop from min stack as well
 * getMin: just return the peek in min stack
 */
public class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            if (x <= minStack.peek()) {
                minStack.push(x);
            }
        }
        stack.push(x);
    }

    public void pop() {
        int val = stack.pop();
        if (val == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * method 2
 * using only one stack
 */
class MinStack1 {
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}

