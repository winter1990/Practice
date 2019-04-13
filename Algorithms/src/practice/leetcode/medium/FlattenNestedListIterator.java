package practice.leetcode.medium;

import practice.leetcode.easy.NestedInteger;

import java.util.*;

public class FlattenNestedListIterator {
}

class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> list;
    Stack<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        list = nestedList;
        stack = new Stack<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            stack.push(list.get(i));
        }
    }

    @Override
    public Integer next() {
        if (hasNext()) {
            return stack.pop().getInteger();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            if (stack.peek().isInteger()) return true;
            NestedInteger cur = stack.pop();
            for (int i = cur.getList().size() - 1; i >= 0; i--) {
                stack.push(cur.getList().get(i));
            }
        }
        return false;
    }
}